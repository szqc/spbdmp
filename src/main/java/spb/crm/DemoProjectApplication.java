package spb.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import spb.crm.comom.proxy.ProxyFactory;
import spb.crm.service.CustomerService;
import spb.crm.service.impl.CustomerServiceImpl;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableAsync
@MapperScan("spb.crm.mapper")
public class DemoProjectApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoProjectApplication.class, args);
    }
}
