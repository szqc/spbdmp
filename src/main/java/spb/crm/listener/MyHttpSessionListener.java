package spb.crm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 会话监听器
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("=======初始化===会话监听器============");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("=======销毁===会话监听器============");
    }
}
