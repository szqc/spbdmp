package spb.crm.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * Servlet请求监听器
 */
@WebListener
public class MyServletListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("=======销毁===请求监听器==========");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("=======初始化===请求监听器==========");
    }
}
