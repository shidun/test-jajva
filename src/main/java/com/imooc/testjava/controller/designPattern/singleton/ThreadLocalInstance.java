package com.imooc.testjava.controller.designPattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal 每个线程独享的资源
 * @author : shidun
 * @date : 2019/12/17
 */
public class ThreadLocalInstance {
    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance() {

    }

    public static ThreadLocalInstance getInstance(){
       return threadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalInstance.getInstance());
        System.out.println(ThreadLocalInstance.getInstance());
        System.out.println(ThreadLocalInstance.getInstance());
        System.out.println(ThreadLocalInstance.getInstance());
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
                System.out.println(instance);
            });
        }
        executorService.shutdown();
    }
}
