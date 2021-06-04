package com.rebwon.ej2a;

public final class Sample {

    private int x = 10;

    // 독립적으로 존재가능하며, 외부 클래스의
    // 멤버에 접근 가능.
    private static class InnerStaticSample {
        void sample() {
            Sample sample = new Sample();
            sample.x = 100;
        }
    }

    void hello() {
        System.out.println("Hello");
    }

    // InnerSample은 static이 아니므로
    // Sample 클래스가 없다면 존재할 수 없다.
    private class InnerSample {
        void sample() {
            Sample.this.hello();
        }
    }

    Inner innerClass() {
        return new Inner() {
            @Override
            public void hell0(String word) {
                System.out.println(word);
            }
        };
    }

    interface Inner {
        void hell0(String word);
    }
}
