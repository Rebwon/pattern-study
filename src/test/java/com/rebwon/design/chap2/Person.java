package com.rebwon.design.chap2;

public final class Person {
    private Role role;

    public Person(Role role) {
        this.role = role;
    }

    public void workEnd(Role role) {
        this.role = role;
    }

    public void workStart() {
        role.work();
    }

    public static void main(String[] args) {
        Person person = new Person(new Role.Driver());
        person.workStart();
        person.workEnd(new Role.Worker());
        person.workStart();
    }

}
