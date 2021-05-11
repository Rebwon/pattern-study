package com.rebwon.design.chap1;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Course> getCourse() {
        return transcripts.stream()
            .map(Transcript::getCourse)
            .collect(Collectors.toSet());
    }

    public void registerTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public void dropTranscript(Transcript transcript) {
        if(transcripts.contains(transcript))
            transcripts.remove(transcript);
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public void advise(String msg) {
        System.out.println(msg);
    }
}
