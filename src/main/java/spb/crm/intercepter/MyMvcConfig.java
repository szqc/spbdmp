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
        registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginIntercepter())
                //.addPathPatterns("/customer/**")//拦截的路径
                .excludePathPatterns("/customer/**")//放行的路径
                .excludePathPatterns("/customer/login");//放行的路径

        registry.addInterceptor(new LoginIntercepterB()).addPathPatterns("/testIntercepter/testA");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
