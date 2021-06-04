package com.rebwon;

import java.util.function.Consumer;
import java.util.function.Function;

public final class IntersectionType {

    interface Pair<T> {
        T getFirst();
        T getSecond();
        void setFirst(T first);
        void setSecond(T second);
    }

    static class Name implements Pair<String> {
        String first;
        String second;

        public Name(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String getFirst() {
            return first;
        }

        @Override
        public String getSecond() {
            return second;
        }

        @Override
        public void setFirst(String first) {
            this.first = first;
        }

        @Override
        public void setSecond(String second) {
            this.second = second;
        }
    }

    interface ForwardingPair<T> extends DelegateTo<Pair<T>>, Pair<T> {

        default T getFirst() {
            return delegate().getFirst();
        }

        default T getSecond() {
            return delegate().getSecond();
        }

        default void setFirst(T first) {
            delegate().setFirst(first);
        }

        default void setSecond(T second) {
            delegate().setSecond(second);
        }
    }

    interface DelegateTo<T> {
        T delegate();
    }

    interface Convertable<T> extends DelegateTo<Pair<T>> {

        default void convert(Function<T, T> mapper) {
            Pair<T> pair = delegate();
            pair.setFirst(mapper.apply(pair.getFirst()));
            pair.setSecond(mapper.apply(pair.getSecond()));
        }
    }

    interface Printer<T> extends DelegateTo<Pair<T>> {

        default void print() {
            System.out.println(delegate().getFirst() + " " + delegate().getSecond());
        }
    }

    private static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static void main(String[] args) {
        Pair<String> name = new Name("Rebwon", "Maeng");
        run((ForwardingPair<String> & Convertable<String> & Printer<String>) () -> name, o -> {
            o.print();
            o.convert(s -> s.toUpperCase());
            o.print();
            o.convert(s -> s.substring(0, 2));
            o.print();
        });
    }
}
