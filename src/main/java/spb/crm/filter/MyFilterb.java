package spb.crm.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(4)
@WebFilter(urlPatterns = "/Filter/*",filterName = "myFilter2")
public class MyFilterb implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init----------------");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy----------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String token = req.getParameter("token");
        System.out.println("====22222===进入了MyFilter=======");
        chain.doFilter(request, response);
//        if(StringUtils.isEmpty(token)){
//            return;
//        }{
//            chain.doFilter(request, response);
//        }
    }
}
