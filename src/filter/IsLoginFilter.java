package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: ÄãÎ¢Ð¦Ê±ºÜÃÀ
 * @Date: 2018/9/21 14:43
 * @Description:ÅÐ¶ÏÊÇ·ñµÇÂ½¹ýÂËÆ÷
 */
@WebFilter(urlPatterns = {"/cart.jsp","/order_info.jsp","/CartServlet"})
public class IsLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object user = request.getSession().getAttribute("user");

        if(user==null){
            response.sendRedirect("login.jsp");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
