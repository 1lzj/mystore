package filter;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CooikeUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: 你微笑时很美
 * @Date: 2018/9/20 14:19
 * @Description:
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");

        if(user==null){
            Cookie cookie = CooikeUtil.getCookie("autoLogin", request.getCookies());
            if(cookie!=null){
                String value = cookie.getValue();

                String[] split = value.split("-");

                String userName = split[0];
                String password = split[1];

                UserService userService = new UserServiceImpl();
                User login = userService.login(userName, password);

                if(login!=null){
                    session.setAttribute("user",login);
                }
            }
        }

        //放行
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
