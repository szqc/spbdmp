package spb.crm.comom.proxy;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    //目标类
    private Object target;

    public Object newProxyInstance(Object targetObject){
        //注入目标类
        this.target = targetObject;
        /**
         * 参数1：目标对象类加载器
         * 参数2：目标对象实现的所有接口
         * 参数3：执行代理对象时触发InvocationHandler的方法（本例子中已经实现了InvocationHandler,传入this，调用本例子的invoke方法）
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            result = method.invoke(target,args);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
