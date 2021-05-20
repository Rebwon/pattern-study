package com.rebwon.design.chap7.book;

public interface State {

    void insertMoney(int money);

    void pushButton(int money);

    void returnMoney();
}
