package com.imooc.testjava.controller.designPattern.bridge;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开一个爱存不存银行账号");
        account.openAccount();
        return account;
    }
}
