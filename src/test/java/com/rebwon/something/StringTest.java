package com.rebwon.something;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class StringTest {

    @Test
    @DisplayName("String pool 바깥에 있던 String 객체를 intern하면 String pool에 추가된다")
    void internedString() {
        String literal = "something";
        String newString = new String("something");
        assertThat(literal).isNotSameAs(newString);

        String internString = newString.intern();
        assertThat(literal).isSameAs(internString);
    }

    @Test
    @DisplayName("HashMap은 동일한 키 값을 중복 저장하지 않으므로, 마지막에 호출한 put메서드의 값이 저장된다.")
    void same_identity() {
        Human human1 = new Human(10);
        Human human2 = new Human(10);
        Map<Human, Integer> map = new HashMap<>();

        map.put(human1, 1);
        map.put(human2, 2);

        assertThat(map.get(human1)).isEqualTo(2);
        assertThat(map.get(human2)).isEqualTo(2);
    }

    public static class Human {
        private int age;

        public Human(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Human human = (Human) o;
            return age == human.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }
}
