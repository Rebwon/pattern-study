package com.rebwon.design.chap9.basic;

import java.util.List;

public final class MinMaxView implements Observer {
    private ScoreRecord scoreRecord;

    public MinMaxView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayMinMax(scores);
    }

    private void displayMinMax(List<Integer> scores) {
        int max = scores.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = scores.stream().mapToInt(Integer::intValue).min().getAsInt();

        System.out.println("Min :" + min + " Max : " + max);
    }
}
