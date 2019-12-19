package com.imooc.testjava.controller.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class clas = target.getClass();
        return Proxy.newProxyInstance(clas.getClassLoader(), clas.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        breforeMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }

    private void breforeMethod(Object object) {
        int userId = 0;
        System.out.println("动态代理， before");
        if (object instanceof Order) {
            Order order = (Order) object;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("动态代理分配到db"+dbRouter);
    }

    private void afterMethod(){
        System.out.println("动态代理， afterMethod");
    }
}
