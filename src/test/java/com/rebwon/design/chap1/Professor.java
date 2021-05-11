package com.rebwon.design.chap1;

public final class Professor {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        student.setAdvisor(this);
    }

    public void advise() {
        student.advise("상담 내용은 여기에..");
    }
}
