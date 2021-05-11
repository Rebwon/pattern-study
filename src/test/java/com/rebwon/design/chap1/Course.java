package com.rebwon.design.chap1;

import java.util.Set;
import java.util.stream.Collectors;

public final class Course {

    private final String id;
    private final String name;
    private Set<Transcript> transcripts;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Student> getStudents() {
        return transcripts.stream()
            .map(Transcript::getStudent)
            .collect(Collectors.toSet());
    }

    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public void removeStudent(Transcript transcript) {
        transcripts.remove(transcript);
    }
}
