package spb.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testIntercepter")
public class TestIntercepter {

    @RequestMapping("testA")
    public void testa(){
        System.out.println("======进入拦截器testA方法======");
    }

    @RequestMapping("testB")
    public void testb(){

    }
}
