package com.imooc.testjava.controller.designPattern.singleton;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Test {

//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        //反射单例
//        //        Class object = Class.forName(HungrySingleton.class.getName());
////        Constructor constructor = object.getDeclaredConstructor();
////        constructor.setAccessible(true);
////        HungrySingleton instance = (HungrySingleton) constructor.newInstance();
////        HungrySingleton newInstance = HungrySingleton.getInstance();
////        System.out.println(instance);
////        System.out.println(newInstance);
////        System.out.println(instance == newInstance);
//
//    //  enum无法被发射 newInstance（）判断为eunm时抛出异常
//        Class object = EnumSingleton.class;
//        Constructor constructor = object.getDeclaredConstructor(String.class, int.class);
//        constructor.setAccessible(true);
//        EnumSingleton enumSingleton = (EnumSingleton) constructor.newInstance();
//    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                ThreadLocalInstance instance = ThreadLocalInstance.getInstance();
                System.out.println(Thread.currentThread().getId());
                System.out.println(instance);
            });
        }
        executorService.shutdown();
    }


//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        HungrySingleton instance = HungrySingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_tone"));
//        oos.writeObject(instance);
//
//        File file = new File("single_tone");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);
//
//
////        ExecutorService executorService = Executors.newCachedThreadPool();
////        for (int i = 0; i < 9; i++) {
////            executorService.execute(()-> {
//////                LazySingleton lazySingleton = LazySingleton.getInstance();
////                LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
////                System.out.println(Thread.currentThread().getName()+lazySingleton);
////            });
////        }
////        executorService.shutdown();
//    }
}
