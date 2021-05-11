package com.rebwon.design.chap1;

import java.util.Set;

public final class Course {

    private final String id;
    private final String name;
    private Set<Student> students;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
