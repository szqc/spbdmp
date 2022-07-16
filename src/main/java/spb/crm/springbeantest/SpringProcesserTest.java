package spb.crm.springbeantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 全局前置、后置初始化的bean,在前置初始化和后置初始化方法执行中，间隔了两个初始化方法
 * BeanPostProcessor接口有两个钩子方法，可以选择实现也可以选择不实现
 */
public class SpringProcesserTest implements BeanPostProcessor {
    /**
     * @param bean  bean是当前被初始化的bean
     * @param beanName  当前被初始化bean的id
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean的生命周期------->前置初始化;bean->"+bean+"--beanName->"+beanName);
        if("testBean".equals(beanName)){
            TestBean testBean = (TestBean) bean;
            testBean.setField("--Q--被全局前置初始化方法修改了属性值--");
            return testBean;
        }else{
            return bean;
        }
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean的生命周期------->后置初始化;bean->"+bean+"--beanName->"+beanName);
        if("testBean".equals(beanName)){
            TestBean testBean = (TestBean) bean;
            testBean.setField("--H--被全局后置初始化方法修改了属性值--");
            return testBean;
        }else{
            return bean;
        }
    }
}
