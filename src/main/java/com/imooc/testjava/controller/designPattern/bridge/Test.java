package com.imooc.testjava.controller.designPattern.bridge;

/**
 * 桥接模式
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class Test {
    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();
        Bank icbcBank1 = new ICBCBank(new SavingAccount());
        Account icbcAccount1 = icbcBank1.openAccount();
        icbcAccount1.showAccountType();

        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();
    }
}
