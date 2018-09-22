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
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 16:57
 * @Description:
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();
    /**
     * 检查用户名是否存在
     * @param request
     * @param response
     * @return
     */
    public String checkUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取用户名
        String userName = request.getParameter("userName");
        User user = service.findUserByName(userName);
        if(user==null){
            //可以使用这个用户名
           response.getWriter().write("ok");
        }else{
            //不可以使用这个用户名
            response.getWriter().write("no");
        }
        return null;
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String to = request.getParameter("email");
        //获取kaptchaValu生存放在Session中的验证码
        String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        User user = new User();
        //获取表单中的验证码
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
                    //跳转到登陆页面
                    SendMail.sendMail(to,code);
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }else{
                    request.setAttribute("mesg","注册失败");
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
            request.setAttribute("checkCodeMsg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        return null;
    }

    /**
     * 激活
     * @param request
     * @param response
     * @return
     */
    public String active(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        int active = service.active(code);
        System.out.println(active);
        if(active>0){
            request.setAttribute("mesg","激活成功，请<a href='login.jsp'>登陆</a>");
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/register.jsp");
        }
        return null;

    }

    /**
     * 用户登陆
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String yzm = request.getParameter("yzm");
        //获取kaptchaValu生存放在Session中的验证码
        String kaptchaValue = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        if(yzm!=null&&yzm!=""&&yzm.equalsIgnoreCase(kaptchaValue)){
            //验证码正确
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            User user = service.login(userName, password);
            if(user!=null){
                if(user.getState()==0){
                    //没有激活，提示信息
                    request.setAttribute("msg","账户还没激活！");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else{
                    request.getSession().setAttribute("user",user);
                    //判断是否勾选了 自动登陆，和记住密码
                    String autoLogin = request.getParameter("autoLogin");
                    String remberName = request.getParameter("remberName");
                        if(autoLogin!=null){ Cookie cookie = new Cookie("autoLogin", userName + "-" + password);
                             cookie.setMaxAge(60*60*24*7);
                            response.addCookie(cookie);
                        }
                        if(remberName!=null){
                            //记住用户名
                            Cookie cookie = new Cookie("remberName", userName);
                            cookie.setMaxAge(60*60*24*7);
                            response.addCookie(cookie);
                        }
                        return "index";
                }
            }else{
                //用户名或密码错误，提示信息
                request.setAttribute("msg","用户名或密码");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            //验证码错误，提示信息
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        return null;
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @return
     */
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //获取客户端所有的Cookie
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
