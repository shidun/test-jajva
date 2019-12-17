package com.imooc.testjava.controller.designPattern.singleton;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class LazyDoubleCheckSingleton {
    //volatile 禁止重排序
    private volatile static  LazyDoubleCheckSingleton lazySingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    public synchronized static LazyDoubleCheckSingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }

}
