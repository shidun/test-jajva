package com.imooc.testjava.controller.designPattern.bridge;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class SavingAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("创建一个活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
