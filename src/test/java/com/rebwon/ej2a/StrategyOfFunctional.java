package com.rebwon.ej2a;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

public final class StrategyOfFunctional {

    private static final Comparator<String> sortWithLength = Comparator.comparingInt(String::length);

    @Test
    void name() {
        final String[] arr = {"1", "2"};

        // 다음과 같이, 익명 클래스를 사용하면,
        // sortWithAnonymous를 호출하는 곳이 여러 곳일 경우
        // 매번 새로운 객체가 만들어지므로 비효율적이다.
        sortWithAnonymousClass(arr);

        // 다음과 같이, private static final 로 만들어서
        // 재사용하자.
        sortWithStaticClass(arr);
    }

    private void sortWithStaticClass(String[] arr) {
        Arrays.sort(arr, sortWithLength);
    }

    public void sortWithAnonymousClass(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
