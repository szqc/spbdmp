package spb.crm.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/testIntercepter/testA");
        registry.addInterceptor(new LoginIntercepterB()).addPathPatterns("/testIntercepter/testA");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
