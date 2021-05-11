package com.rebwon.design.chap1;

public final class Person {
    private Phone homePhone;
    private Phone officePhone;
    private Car owns;

    public void setOwns(Car owns) {
        this.owns = owns;
    }

    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }
}
