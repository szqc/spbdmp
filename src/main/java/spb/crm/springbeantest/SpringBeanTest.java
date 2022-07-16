package spb.crm.springbeantest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("springbean.xml");
        TestBean testBean = app.getBean(TestBean.class);
        app.close();
    }
}

