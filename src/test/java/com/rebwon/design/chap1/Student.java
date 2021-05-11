package com.rebwon.design.chap1;

import java.util.Set;

public final class Student {

    private final String name;
    private final String studentNumber;
    private Professor advisor;
    private Set<Transcript> transcripts;
    private School school;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public void registerTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public void dropTranscript(Transcript transcript) {
        transcripts.remove(transcript);
    }
}
