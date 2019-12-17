package com.imooc.testjava.controller.designPattern.singleton;

import java.io.Serializable;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class HungrySingleton implements Serializable, Cloneable{
//    private final static HungrySingleton hungrySingleton = new HungrySingleton();
    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("不能反射");
        }
    }
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * readResolve 方法实现单例模式下 序列化和反序列化后不相等问题
     * @return
     */
    private Object readResolve() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
