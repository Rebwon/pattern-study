package com.rebwon.design.chap1;

import java.util.Set;

public final class Course {

    private final String id;
    private final String name;
    private Set<Transcript> transcripts;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Transcript transcript) {
        transcripts.add(transcript);
    }

    public void removeStudent(Transcript transcript) {
        transcripts.remove(transcript);
    }
}
