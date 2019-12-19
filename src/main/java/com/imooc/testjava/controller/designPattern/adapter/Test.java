package com.imooc.testjava.controller.designPattern.adapter;

/**
 * 适配器模式
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class Test {

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter();
        dc5.outputDC5();
    }
}
