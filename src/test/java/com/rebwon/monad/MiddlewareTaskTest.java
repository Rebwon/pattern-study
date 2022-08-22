package com.rebwon.monad;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

public final class MiddlewareTaskTest {

    @Test
    void ss() {
        // Arrange
        var sut = CompensatoryTask.of(this::subtractStock, this::revokeStock)
            .andThen(this::useCoupon, this::revokeCoupon);

        // Act

        // Assert
    }

    private RuntimeException revokeCoupon(Object o, RuntimeException e) {
        return null;
    }

    private Object useCoupon(Object o) {
        return null;
    }

    private <T> RuntimeException revokeStock(T t, RuntimeException e) {
        return null;
    }

    private <T> T subtractStock(T t) {
        return null;
    }

    @Test
    void name() {
        // Arrange
        var greeter = MiddlewareTask.of(this::upperCase)
            .andThen(this::extract);

        // Act
        String result = greeter.run("NewYork City", name -> "Hello" + name);

        // Assert
        assertThat(result).isEqualTo("NEWYORK=HelloCITY");
    }

    private String extract(String value, Function<String, String> next) {
        String[] token = value.split(" ");
        String param = token[0];
        String result = next.apply(token[1]);
        return param + "=" + result;
    }

    private String upperCase(String value, Function<String, String> next) {
        String upperCase = value.toUpperCase();
        return next.apply(upperCase);
    }

}
