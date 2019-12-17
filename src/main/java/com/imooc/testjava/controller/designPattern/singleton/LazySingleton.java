package com.imooc.testjava.controller.designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private static boolean flag = true;
    //设置flag也是无效   可以通过反射修改flag
    private LazySingleton() {
        if (flag) {
            flag = false;
        } else {
            throw new RuntimeException("不能反射");
        }
    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 反射单例  懒加载无法防御反射攻击
     * @param args
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class object = LazySingleton.class;
        Constructor constructor = object.getDeclaredConstructor();
        constructor.setAccessible(true);

        LazySingleton newInstance = LazySingleton.getInstance();
        Field field = object.getDeclaredField("flag");
        field.setAccessible(true);
        field.set(newInstance, true);

        LazySingleton instance = (LazySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

    }
}
