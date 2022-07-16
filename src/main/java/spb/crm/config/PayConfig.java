package spb.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource({"classpath:pay.properties"})
public class PayConfig implements Serializable {

    @Value("${wx.appId}")
    private String wxAppId;

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }
}
