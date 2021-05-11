package com.rebwon.design.chap1;

import java.time.LocalDate;

public final class Transcript {

    private Student student;
    private Course course;
    private String grade;
    private LocalDate startedCourseDate;

    public Transcript(Student student, Course course) {
        this.student = student;
        this.student.registerTranscript(this);
        this.course = course;
        this.course.addTranscript(this);
    }

    public Course getCourse() {
        return this.course;
    }

    public Student getStudent() {
        return student;
    }
}
