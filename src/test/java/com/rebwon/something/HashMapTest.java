package com.rebwon.something;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public final class HashMapTest {

    @Test
    void name() {
        Map<Owner, Integer> map = new HashMap<>();

        map.put(new Owner("kim"), 1);
        //map.put(new Owner("kim"), 2);
        map.put(new Owner("jeremy"), 2);

        assertThat(map.size()).isEqualTo(2);
    }

    static class Owner {
        private String name;

        public Owner(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Owner owner = (Owner) o;
            return Objects.equals(name, owner.name);
        }

        @Override
        public int hashCode() {
            //return Objects.hash(name);
            return 1;
        }
    }
}
