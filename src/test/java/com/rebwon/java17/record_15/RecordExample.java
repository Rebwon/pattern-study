package com.rebwon.java17.record_15;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public final class RecordExample {

    // compact constructor
    record Rectangle(double length, double width) {
        public Rectangle {
            if (length <= 0 || width <= 0) {
                throw new IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", length, width));
            }
        }

        // nested record
        record RotationAngle(double angle) {
            public RotationAngle {
                angle = Math.toRadians(angle);
            }
        }

        public Rectangle getRotatedRectangleBoundingBox(double angle) {
            RotationAngle ra = new RotationAngle(angle);
            double x = Math.abs(length * Math.cos(ra.angle())) +
                Math.abs(width * Math.sin(ra.angle()));
            double y = Math.abs(length * Math.sin(ra.angle())) +
                Math.abs(width * Math.cos(ra.angle()));
            return new Rectangle(x, y);
        }

        public double length() {
            System.out.println("길이입니다.");
            return length;
        }
    }

    @Test
    void record_explicit_method() {
        Rectangle rectangle = new Rectangle(1, 2);

        double length = rectangle.length;
        double length1 = rectangle.length();
    }

    @Test
    void record_instance_compact_constructor() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Rectangle(0, 0));
    }
}
