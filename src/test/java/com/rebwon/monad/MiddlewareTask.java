package com.rebwon.monad;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class MiddlewareTask<T, R> {

    private final BiFunction<T, Function<T, R>, R> middleware;

    private MiddlewareTask(BiFunction<T, Function<T, R>, R> middleware) {
        this.middleware = middleware;
    }

    public static <T, R> MiddlewareTask<T, R> of(BiFunction<T, Function<T, R>, R> middleware) {
        return new MiddlewareTask<>(middleware);
    }

    public static <T, R> MiddlewareTask<T, R> empty() {
        return new MiddlewareTask<>((value, next) -> next.apply(value));
    }

    public MiddlewareTask<T, R> andThen(MiddlewareTask<T, R> after) {
        BiFunction<T, Function<T, R>, R> function =
            (value, next) -> middleware.apply(value, value2 -> after.middleware.apply(value2, next));
        return new MiddlewareTask<>(function);
    }

    public MiddlewareTask<T, R> andThen(BiFunction<T, Function<T, R>, R> middleware) {
        return andThen(MiddlewareTask.of(middleware));
    }

    public R run(T param, Function<T, R> task) {
        return middleware.apply(param, task);
    }
}
