package setvlet;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CooikeUtil;
import utils.MyDateConvert;
import utils.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: ��΢Цʱ����
 * @Date: 2018/9/19 16:57
 * @Description:
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();
    /**
     * ����û����Ƿ����
     * @param request
     * @param response
     * @return
     */
    public String checkUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //��ȡ�û���
        String userName = request.getParameter("userName");
        User user = service.findUserByName(userName);
        if(user==null){
            //����ʹ������û���
           response.getWriter().write("ok");
        }else{
            //������ʹ������û���
            response.getWriter().write("no");
        }
        return null;
    }

    /**
     * ע��
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String to = request.getParameter("email");
        //��ȡkaptchaValu�������Session�е���֤��
        String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        User user = new User();
        //��ȡ���е���֤��
        String checkCode = request.getParameter("checkCode");

        if(checkCode.equalsIgnoreCase(kaptchaValue)){
            try {
                ConvertUtils.register(new MyDateConvert(), Date.class);
                BeanUtils.populate(user,map);
                user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
                user.setState(0);

                String code = UUID.randomUUID().toString().replaceAll("-","");
                user.setCode(code);

                boolean b = service.registerUser(user);
                if(b){
                    //��ת����½ҳ��
                    SendMail.sendMail(to,code);
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }else{
                    request.setAttribute("mesg","ע��ʧ��");
                    request.getRequestDispatcher("/info.jsp").forward(request,response);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("checkCodeMsg","��֤�����");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        return null;
    }

    /**
     * ����
     * @param request
     * @param response
     * @return
     */
    public String active(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        int active = service.active(code);
        System.out.println(active);
        if(active>0){
            request.setAttribute("mesg","����ɹ�����<a href='login.jsp'>��½</a>");
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/register.jsp");
        }
        return null;

    }

    /**
     * �û���½
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String yzm = request.getParameter("yzm");
        //��ȡkaptchaValu�������Session�е���֤��
        String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        if(yzm!=null&&yzm!=""&&yzm.equalsIgnoreCase(kaptchaValue)){
            //��֤����ȷ
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            User user = service.login(userName, password);
            if(user!=null){
                if(user.getState()==0){
                    //û�м����ʾ��Ϣ
                    request.setAttribute("msg","�˻���û���");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else{
                    request.getSession().setAttribute("user",user);
                    //�ж��Ƿ�ѡ�� �Զ���½���ͼ�ס����
                    String autoLogin = request.getParameter("autoLogin");
                    String remberName = request.getParameter("remberName");
                        if(autoLogin!=null){ Cookie cookie = new Cookie("autoLogin", userName + "-" + password);
                             cookie.setMaxAge(60*60*24*7);
                            response.addCookie(cookie);
                        }
                        if(remberName!=null){
                            //��ס�û���
                            Cookie cookie = new Cookie("remberName", userName);
                            cookie.setMaxAge(60*60*24*7);
                            response.addCookie(cookie);
                        }
                        return "index";
                }
            }else{
                //�û��������������ʾ��Ϣ
                request.setAttribute("msg","�û���������");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            //��֤�������ʾ��Ϣ
            request.setAttribute("msg","��֤�����");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        return null;
    }

    /**
     * �û��˳�
     * @param request
     * @param response
     * @return
     */
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //��ȡ�ͻ������е�Cookie
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CooikeUtil.getCookie("autoLogin", cookies);
        if(cookie!=null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        session.removeAttribute("cart");
        session.removeAttribute("user");
        return "index";
    }
}
