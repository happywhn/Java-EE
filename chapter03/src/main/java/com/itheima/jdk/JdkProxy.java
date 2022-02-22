package com.itheima.jdk;

import com.itheima.aspect.MyAspect;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {
    private UserDao userDao;

    public Object createProxy(UserDao userDao) {
        this.userDao=userDao;
        //类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        //被代理对象实现的所有接口
        Class[] clazz=userDao.getClass().getInterfaces();
        //使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader,clazz,this);
    }

    /**
     * 所有动态代理类的方法调用，都会交给invoke()方法去处理
     * @param proxy 被代理后的对象
     * @param method 将要被执行的方法西南西（反射）
     * @param args 执行方法时需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        MyAspect myAspect=new MyAspect();
        //前增强
        myAspect.check_Permission();
        //在目标类薛航调用方法，并传入参数
        Object obj=method.invoke(userDao,args);
        //后增强
        myAspect.log();
        return obj;
    }
}
