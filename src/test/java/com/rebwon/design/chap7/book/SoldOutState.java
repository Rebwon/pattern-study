package com.rebwon.design.chap7.book;

public final class SoldOutState implements State {
    private VendingMachine machine;

    public SoldOutState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(int money) {
        System.out.println("재고가 없습니다.");
    }

    @Override
    public void pushButton(int money) {

    }

    @Override
    public void returnMoney() {
        int temp = machine.getMoneyBox().returnMoney();
        System.out.println(temp + " 원이 반환되었습니다.");
        machine.setState(machine.getNoMoneyState());
    }
}
