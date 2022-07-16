package spb.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class VideoController {

    @RequestMapping("test_json")
    public Object List(){
        Map<String,String> map = new HashMap<>();
        map.put("1","SpringBoot知识点");
        map.put("2","微服务知识点");
        return map;
    }
}
