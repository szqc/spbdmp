package spb.crm.intercepter;


import com.fasterxml.jackson.databind.json.JsonMapper;
import spb.crm.util.JsonData;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginIntercepterB implements HandlerInterceptor {
    private static JsonMapper jsonMapper = new JsonMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JsonData jsonData = new JsonData(null,"123000",false,"LoginIntercepterB，没有访问权限");
        writeResp(response,jsonData);
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 把字符串写入到响应中
     * @param response
     * @param data
     * @throws IOException
     */
    public void writeResp(ServletResponse response, Object data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String json = jsonMapper.writeValueAsString(data);
        writer.print(json);
    }
}
