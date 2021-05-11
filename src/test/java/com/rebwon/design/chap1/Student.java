package com.rebwon.design.chap1;

import java.util.Set;

public final class Student {

    private final String name;
    private final String studentNumber;
    private Professor advisor;
    private Set<Course> courses;
    private School school;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public void registerCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void dropCourse(Course course) {
        course.removeStudent(this);
        courses.remove(course);
    }
}
