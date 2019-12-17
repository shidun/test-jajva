package com.imooc.testjava.controller.designPattern.singleton;

import lombok.Data;

/**
 * @author : shidun
 * @date : 2019/12/17
 */
public enum  EnumSingleton {
    instance;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return instance;
    }
}
