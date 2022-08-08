package spb.crm.filter;

import com.fasterxml.jackson.databind.json.JsonMapper;
import spb.crm.util.JsonData;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@Order(1)
@WebFilter(urlPatterns = "/Filter/*",filterName = "myFilter3")
public class LoginFilter implements Filter {

    private static JsonMapper jsonMapper = new JsonMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("====111111===进入MyFilter01过滤器========");

        JsonData jsonData = new JsonData(null,"123000",false,"没有权限");
        writeResp(response,jsonData);
        //chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 把字符串写入到响应中
     * @param response
     * @param json
     * @throws IOException
     */
    public void writeResp(ServletResponse response,Object data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String json = jsonMapper.writeValueAsString(data);
        writer.print(json);
    }
}
