package com.rebwon.design.chap9.basic;

import java.util.List;

public final class DataSheetView implements Observer {

    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScores();
        displayScores(record, viewCount);
    }

    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of " + viewCount + " entries: ");
        for(Integer score : record) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
