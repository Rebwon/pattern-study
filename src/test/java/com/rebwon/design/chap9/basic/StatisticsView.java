package com.rebwon.design.chap9.basic;

import java.util.List;

public final class StatisticsView implements Observer {

    private ScoreRecord scoreRecord;

    public StatisticsView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        display(scores);
    }

    private void display(List<Integer> scores) {
        int sum = scores.stream().mapToInt(Integer::intValue).sum();
        double average = scores.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Sum : " + sum + " Average : " + average);
    }
}
