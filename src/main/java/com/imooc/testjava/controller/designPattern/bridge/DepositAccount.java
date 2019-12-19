package com.imooc.testjava.controller.designPattern.bridge;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("创建一个定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
