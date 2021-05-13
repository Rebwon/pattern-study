package com.rebwon.design.chap3;

import java.util.ArrayList;
import java.util.List;

public final class PayrollManager {

    private List<Employee> employees = new ArrayList<>();

    public void writeEmployeePay() {
        employees.stream()
            .mapToInt(Employee::calculatePay)
            .forEach(System.out::println);
    }
}
