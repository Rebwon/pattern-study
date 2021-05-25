package com.rebwon.design.chap9.basic;

import java.util.ArrayList;
import java.util.List;

public final class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();
    private Subject subject;

    public ScoreRecord(Subject subject) {
        this.subject = subject;
    }

    public void addScore(int score) {
        scores.add(score);

        subject.notifyObserver();
    }

    public List<Integer> getScores() {
        return scores;
    }
}
