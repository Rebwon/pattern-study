package com.rebwon.monad;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public final class CompensatoryTask<T> {

    private final MiddlewareTask<T, T> task;

    private CompensatoryTask(MiddlewareTask<T, T> task) {
        this.task = task;
    }

    public static <T> CompensatoryTask<T> of(
        UnaryOperator<T> action,
        BiFunction<T, RuntimeException, RuntimeException> compensation
    ) {
        return new CompensatoryTask<>(
            MiddlewareTask.of(
                (value, next) -> {
                    try {
                        return next.apply(action.apply(value));
                    } catch (RuntimeException e) {
                        throw compensation.apply(value, e);
                    }
                }
            )
        );
    }

    public static <T> CompensatoryTask<T> empty() {
        return new CompensatoryTask<>(MiddlewareTask.empty());
    }

    public CompensatoryTask<T> andThen(
        UnaryOperator<T> action,
        BiFunction<T, RuntimeException, RuntimeException> compensation
    ) {
        return andThen(CompensatoryTask.of(action, compensation));
    }

    public CompensatoryTask<T> andThen(CompensatoryTask<T> compensatoryTask) {
        return new CompensatoryTask<>(task.andThen(compensatoryTask.task));
    }

    public T run(T init) {
        return task.run(init, it -> null);
    }
}
