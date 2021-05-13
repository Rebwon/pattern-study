package com.rebwon.design.chap3;

import java.util.ArrayList;
import java.util.List;

public final class PayrollManager {

    private List<Employee> employees = new ArrayList<>();
    private Printer printer;

    public void writeEmployeePay() {
        employees.stream()
            .mapToInt(Employee::calculatePay)
            .forEach(pay -> printer.print(pay));
    }

    interface Printer {
        void print(int pay);
    }
}
