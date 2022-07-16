package spb.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Filter")
public class TestFilterController {

    @RequestMapping("test")
    public void test(){
        System.out.println("=========测试Filter============");
    }
}
