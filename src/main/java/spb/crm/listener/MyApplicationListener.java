package spb.crm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用启动监听器，即上下文监听器
 */
@WebListener
public class MyApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=======初始化=====应用启动监听器============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=======销毁=======应用启动监听器============");
    }
}
