package com.rebwon.design.chap9.basic;

public final class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();
        ScoreRecord scoreRecord = new ScoreRecord(subject);
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);
        subject.attach(dataSheetView);
        subject.attach(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("Adding : " + score);
            scoreRecord.addScore(score);
        }

        subject.detach(dataSheetView);
        StatisticsView statisticsView = new StatisticsView(scoreRecord);
        subject.attach(statisticsView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("Adding : " + score);
            scoreRecord.addScore(score);
        }
    }
}
