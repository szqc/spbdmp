package spb.crm.service.impl;

import org.springframework.stereotype.Service;
import spb.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void study(String courseName) {
        System.out.println("----目标对象study方法----练习："+courseName);
    }
}
