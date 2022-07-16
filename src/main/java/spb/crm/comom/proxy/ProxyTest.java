package spb.crm.comom.proxy;

import spb.crm.service.CustomerService;
import spb.crm.service.UserService;
import spb.crm.service.impl.CustomerServiceImpl;
import spb.crm.service.impl.UserServiceImpl;

public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        UserService target = new UserServiceImpl();
        //代理对象
        UserService proxy = (UserService) new ProxyFactory().getProxyInstance(target);
        proxy.study("SpringCloud");
    }
}
