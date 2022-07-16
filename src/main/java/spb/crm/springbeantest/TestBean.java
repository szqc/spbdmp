package spb.crm.springbeantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class TestBean implements BeanNameAware,BeanFactoryAware,ApplicationContextAware, InitializingBean, DisposableBean {

    private String field;

    public TestBean() {
        System.out.println("Bean的生命周期---1111---->调用WW无参构成方法");
    }

    public TestBean(String field) {
        System.out.println("Bean的生命周期---1111---->调用YY有参构成方法");
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        System.out.println("Bean的生命周期---2222---->设置属性setField,属性值："+field);
        this.field = field;
    }

    //设置bean的id，当xml中没有配置id时，显示 全限定名+#0，当xml配置了bean的id，此时name的值是bean的id
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean的生命周期---3333---->实现BeanNameAware接口的setBeanName方法：name-->"+name);
    }

    //设置bean容器
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean的生命周期---4444---->实现BeanFactoryAware接口的setBeanFactory方法：beanFactory-->"+beanFactory);
    }

    //设置容器，有时候在bean里获取其他的对象，除了依赖注入，还可以在bean里注入一个容器，再通过容器来拿对象
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Bean的生命周期---5555---->实现ApplicationContexAware接口的setApplicationContext方法：applicationContext-->"+applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean的生命周期---6666---->实现InitializingBean接口的afterPropertiesSet方法");

    }
    public void  init(){
        System.out.println("Bean的生命周期---7777---->实现自定义init方法");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean的生命周期---8888---->实现DisposableBean接口的destroy销毁方法");
    }
    public void des(){
        System.out.println("Bean的生命周期---9999---->实现自定义的des销毁方法");
    }
}
