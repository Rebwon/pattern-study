package com.rebwon.design.chap7;

public final class EnoughMoneyState implements State {
    private VendingMachine machine;

    public EnoughMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(int money) {
        machine.getMoneyBox().insert(money);

        System.out.println(money + " 원을 넣었습니다.");
        System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + " 원입니다.");
    }

    @Override
    public void pushButton(int money) {
        machine.getMoneyBox().dispense(money);
        machine.getDrinking().dispense();
        System.out.println("음료수가 나왔습니다.");

        if(machine.getDrinking().getStock() == 0) {
            machine.setState(machine.getSoldOutState());
        } else if(machine.getMoneyBox().getMoney() < machine.getDrinking().getPrice()) {
            machine.setState(machine.getNoEnoughMoneyState());
        } else if(machine.getMoneyBox().getMoney() == 0){
            machine.setState(machine.getNoMoneyState());
        }
    }

    @Override
    public void returnMoney() {
        int temp = machine.getMoneyBox().returnMoney();
        System.out.println(temp + " 원이 반환되었습니다.");
        machine.setState(machine.getNoMoneyState());
    }
}
