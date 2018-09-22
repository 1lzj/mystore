package setvlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/19 14:18
 * @Description:
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取方法名称
        String methodName = req.getParameter("methodName");

        Class<? extends BaseServlet> clzz = this.getClass();

        try {
            Method method = clzz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Object view =  method.invoke(this, req, resp);
            if(view!=null){
                resp.sendRedirect(req.getContextPath()+"/"+view+".jsp");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
