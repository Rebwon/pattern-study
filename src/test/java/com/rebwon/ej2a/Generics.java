package com.rebwon.ej2a;

import java.util.List;
import java.util.Set;

public final class Generics {

    // 접근제어자 제네릭타입 반환타입 메서드명(인자)
    public <T extends Number> void some(List<T> list) {

    }

    public <T extends Comparable<T>> void compare(T t) {

    }

    public void zero(List<?> list) {

    }

    public static <E extends String> Set<E> union(Set<E> s1, Set<E> s2) {
        return null;
    }
}
