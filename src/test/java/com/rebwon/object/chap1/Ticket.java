package com.rebwon.object.chap1;

public final class Ticket {

    public static final Ticket EMPTY = new Ticket(null);

    private final Theater theater;
    private boolean isEntered = false;

    public Ticket(Theater theater) {
        this.theater = theater;
    }

    public boolean isValid(Theater theater) {
        if (isEntered || this.theater != theater || this == EMPTY) {
            return false;
        } else {
            isEntered = true;
            return true;
        }
    }

    // 포인터의 포인터를 통해 theater의 fee 값이 변경되었을 때
    // 그 값에 접근이 가능하다.
    // 만약 theater의 fee를 생성자나 setter로 직접 받았다면
    // 런타임에 theater의 fee가 변경되었을 때
    // 그 변경에 대한 참조를 가지지 않으므로, 이전 값을 계속 바라보게 된다.
    public Long getFee() {
        return theater.getFee();
    }
}
