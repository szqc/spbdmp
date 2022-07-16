package spb.crm.controller;

import spb.crm.config.PayConfig;
import spb.crm.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("testc")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Value("${wx.appId}")
    private String wxId;

    @Autowired
    private PayConfig payConfig;

    @RequestMapping("getConfigInfo")
    public JsonData getConfigInfo() throws Exception{
        Map map = new HashMap<>();
        map.put("appId",payConfig.getWxAppId());
        try {
            int i = 1 / 0;
        }catch (Exception e){
//            throw   new NullPointerException();
            throw   new Exception();
        }

        return new JsonData(map,true,"");
    }
}
