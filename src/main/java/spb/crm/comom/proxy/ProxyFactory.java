package spb.crm.comom.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，给多个目标对象生产代理对象
 */
public class ProxyFactory {
    //目标对象
    private Object target;
    /**
     * 返回目标对象(target)的代理对象(proxy)
     */
    public Object getProxyInstance(Object target){
        this.target = target;//目标对象
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象的类加载器
                target.getClass().getInterfaces(),//目标对象实现的所有接口
                new InvocationHandler() { //执行代理方法时触发InvocationHandler的invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //获取当前方法的方法名
                        String methodName = method.getName();
                        Object result = null;
                        System.out.println("执行目标对象方法前的代理对象AOP增强---QQQ---");
                        result = method.invoke(target,args);
                        System.out.println("执行目标对象方法后的代理对象AOP增强---HHH---");
                        return result;
                    }
                });
        return proxy;
    }
}
