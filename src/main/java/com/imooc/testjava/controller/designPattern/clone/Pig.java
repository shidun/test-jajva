package com.imooc.testjava.controller.designPattern.clone;

import com.imooc.testjava.controller.designPattern.singleton.HungrySingleton;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 直接调用super.clone()是浅拷贝
 * 对象的引用也是指向同一个 需要改写clone() 才能改为深拷贝
 * @author : SHIDUN
 * @date : 2019/12/17
 */
@Data
public class Pig implements Cloneable{
    private String name;
    private Integer age;
    private Date birthday;
    private List data;

    public Pig(String name, Integer age, Date birthday, List data) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.data = data;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深拷贝
        Pig pig = (Pig) super.clone();
        pig.birthday = (Date) pig.getBirthday().clone();
        pig.data = new ArrayList(pig.getData());
        return pig;

        //浅拷贝
//        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Pig pig = new Pig("pig猪", 11, new Date(0L), new ArrayList(Arrays.asList(1, 2, 3)));
        Pig pig1 = (Pig) pig.clone();
        System.out.println(pig);
        System.out.println(pig1);
//        pig.getBirthday().setTime();
        pig.setBirthday(new Date(222222111111L));
        pig.getData().add(5);
        pig.setName("2222");
        pig.setAge(33);
        System.out.println(pig);
        System.out.println(pig1);

//        // 反射和拷贝对单例的影响
//        HungrySingleton singleton = HungrySingleton.getInstance();
//        Class object = Class.forName(HungrySingleton.class.getName());
//        Method method = object.getDeclaredMethod("clone");
//        method.setAccessible(true);
//        HungrySingleton singleton1 = (HungrySingleton) method.invoke(singleton);
//        System.out.println(singleton);
//        System.out.println(singleton1);
    }
}
