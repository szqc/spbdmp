package spb.crm.comom.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@Aspect
public class ServiceAspect {
    @Before("execution(* *spb.crm.controller.*.*(..))")
    public void beforeLog(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("---切面---Before通知----");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        System.out.println("---切面---执行的URL---->"+request.getRequestURL());
        System.out.println("---切面---执行的方法---->"+joinPoint.getSignature().getName());

    }
    @After("execution(* *spb.crm.controller.*.*(..))")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("---切面---After通知----");
    }
}
