package com.imooc.testjava.controller.designPattern.adapter;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class PowerAdapter implements DC5 {
    private Ac220 ac220 = new Ac220();

    @Override
    public int outputDC5() {
        int output = ac220.input220();
        int intput = output/44;
        System.out.println("转成" + intput);
        return intput;
    }
}
