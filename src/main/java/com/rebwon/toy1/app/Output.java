package com.rebwon.toy1.app;

import com.rebwon.toy1.model.Player;

public final class Output {

    public static void prepareMode() {
        System.out.println("모드를 선택해주세요");
        System.out.println("1. Single 2. Multi 3. Exit");
    }

    public static void exit() {
        System.out.println("게임을 종료합니다.");
    }

    public static void singleMode() {
        System.out.println("싱글 플레이어 모드입니다.");
    }

    public static void inputNumber() {
        System.out.println("숫자를 입력해주세요.");
    }

    public static void inputNumber(Player player) {
        System.out.println(player.getName() + "님 " + "숫자를 입력해주세요.");
    }

    public static void resultSingleMode(int numberOfAttempt) {
        System.out.println("정답까지 시도한 횟수 : " + numberOfAttempt);
    }

    public static void resultMultiMode(Player winner) {
        System.out.println("승자는 " + winner.getName() + "입니다.");
    }

    public static void multiMode() {
        System.out.println("멀티 플레이어 모드입니다.");
        System.out.println("플레이어 이름을 ,를 기준으로 입력해주세요.");
    }
}
