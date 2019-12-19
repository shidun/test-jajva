package com.imooc.testjava.controller.designPattern.bridge;

import lombok.Data;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public abstract class Bank {
    protected Account account;
    public Bank(Account account) {
        this.account = account;
    }
    abstract Account openAccount();
}
