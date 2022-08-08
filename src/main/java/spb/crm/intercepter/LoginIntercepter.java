package spb.crm.intercepter;

import com.fasterxml.jackson.databind.json.JsonMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;
import spb.crm.util.JsonData;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import spb.crm.util.JwtUtils;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginIntercepter implements HandlerInterceptor {
    private static JsonMapper jsonMapper = new JsonMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String token = request.getHeader("token");
            if(token == null){
                token = request.getParameter("token");
            }
            if(!StringUtils.isEmpty(token)){
                Claims claims = JwtUtils.checkJWT(token);
                if(claims == null){
                    //需要重新登录
                    JsonData jsonData = new JsonData(null,"123000",false,"拦截器，请重新登录");
                    writeResp(response,jsonData);//实际项目中是跳转到登录界面，如果前后端分离的，后端返回jsonjson提示前端根据提示自行控制跳转到登录界面
                    return false;
                }
                String name = (String)claims.get("name");
                request.setAttribute("customerName",name);
                return true;
            }
        }catch (Exception e){}
        JsonData jsonData = new JsonData(null,"123000",false,"拦截器，请重新登录");
        writeResp(response,jsonData);//实际项目中是跳转到登录界面，如果前后端分离的，后端返回jsonjson提示前端根据提示自行控制跳转到登录界面
        return false;
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
