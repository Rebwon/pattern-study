package com.rebwon.java17.switch_14;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class SwitchExample {

    @Test
    void switch_example1() {
        int mark = 80;

        String grade = switch (mark) {
            case 90 -> "A";
            case 80 -> "B";
            case 70 -> "C";
            case 60 -> "D";
            default -> "F";
        };

        assertThat(grade).isEqualTo("B");
    }

    public static double getPerimeter1(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    // preview 17 pattern matching switch expressions
    public static double getPerimeter2(Shape shape) throws IllegalArgumentException {
        return switch (shape) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c    -> 2 * c.radius() * Math.PI;
            default          -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    interface Shape { }
    record Rectangle(double length, double width) implements Shape { }
    record Circle(double radius) implements Shape { }
}
