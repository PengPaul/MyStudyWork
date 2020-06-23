package com.java_performance.chapter02.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDbQueryHandler implements InvocationHandler {
    private IDBQuery real = null;
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJdkProxy(){
        IDBQuery jdkProxy = (IDBQuery)Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[] {IDBQuery.class},
                new JdkDbQueryHandler());
        return jdkProxy;
    }
}
