package com.rebwon.design.chap7;

public interface State {

    void insertMoney(int money);

    void pushButton(int money);

    void returnMoney();
}
