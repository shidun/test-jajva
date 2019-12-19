package com.imooc.testjava.controller.designPattern.bridge;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class ABCBank extends Bank {

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开一个农业银行账号");
        account.openAccount();
        return account;
    }
}
