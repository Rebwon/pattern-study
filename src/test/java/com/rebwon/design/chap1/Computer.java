package com.rebwon.design.chap1;

public final class Computer {
    private MainBoard mainBoard;
    private Memory memory;
    private Cpu cpu;
    private PowerSupply powerSupply;

    // 집계 관계와 합성 관계를 알고 싶다면,
    // 전체 객체와 부분 객체의 라이프 사이클 의존성이
    // 같은지 다른지 살펴보라.

    // 아래와 같이 생성자의 인자로 참조를 받는 관계는
    // 집계(Aggregation) 관계
    public Computer(MainBoard mainBoard, Memory memory, Cpu cpu,
        PowerSupply powerSupply) {
        this.mainBoard = mainBoard;
        this.memory = memory;
        this.cpu = cpu;
        this.powerSupply = powerSupply;
    }

    // 아래와 같이 Computer라는 객체의 인스턴스 computer1이
    // 존재하다가 없어질 경우, 아래에 있는 부품 객체도 같이 없어지므로
    // 합성(Composition) 관계라고 한다.
    public Computer() {
        this.mainBoard = new MainBoard();
        this.memory = new Memory();
        this.cpu = new Cpu();
        this.powerSupply = new PowerSupply();
    }

    public static class MainBoard {

    }

    public static class Cpu {

    }

    public static class Memory {

    }

    public static class PowerSupply {

    }
}
