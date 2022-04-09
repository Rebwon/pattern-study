package com.rebwon.java17.string_11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public final class StringExample {

    @Test
    void char_is_whitespace() {
        boolean result = Character.isWhitespace(' ');

        assertThat(result).isTrue();
    }

    @Test
    void char_is_not_whitespace() {
        boolean result = Character.isWhitespace('a');

        assertThat(result).isFalse();
    }

    @Test
    void string_is_empty() {
        boolean result = "".isEmpty();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_empty() {
        boolean result = "abc".isEmpty();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_blank() {
        boolean result = " ".isBlank();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_blank() {
        boolean result = "abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_not_blank_with_space() {
        boolean result = " abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_not_blank_with_tab() {
        boolean result = " \t".isBlank();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_blank_with_newline() {
        boolean result = " \n".isBlank();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_blank_with_carriage_return() {
        boolean result = " \r".isBlank();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_blank_with_formfeed() {
        boolean result = " \f".isBlank();

        assertThat(result).isTrue();
    }

    @Test
    void string_is_not_blank_with_tab_and_space() {
        boolean result = " \t abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_not_blank_with_newline_and_space() {
        boolean result = " \n abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_not_blank_with_carriage_return_and_space() {
        boolean result = " \r abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_is_not_blank_with_formfeed_and_space() {
        boolean result = " \f abc".isBlank();

        assertThat(result).isFalse();
    }

    @Test
    void string_lines() {
        Stream<String> lines = "Hello World".lines();

        assertThat(lines).containsExactly("Hello World");
    }

    @Test
    void string_lines_with_newline() {
        Stream<String> lines = "Hello\nWorld".lines();

        assertThat(lines).containsExactly("Hello", "World");
    }

    @Test
    void string_lines_with_carriage_return() {
        Stream<String> lines = "Hello\rWorld".lines();

        assertThat(lines).containsExactly("Hello", "World");
    }

    @Test
    void string_lines_with_carriage_return_and_newline() {
        Stream<String> lines = "Hello\r\nWorld".lines();

        assertThat(lines).containsExactly("Hello", "World");
    }

    @Test
    void string_lines_with_newline_and_carriage_return() {
        Stream<String> lines = "Hello\n\rWorld".lines();

        assertThat(lines).containsExactly("Hello", "", "World");
    }

    @Test
    void string_lines_with_newline_and_carriage_return_and_newline() {
        Stream<String> lines = "Hello\n\r\nWorld".lines();

        assertThat(lines).containsExactly("Hello", "", "World");
    }

    @Test
    void string_lines_with_carriage_return_and_newline_and_carriage_return() {
        Stream<String> lines = "Hello\r\n\rWorld".lines();

        assertThat(lines).containsExactly("Hello", "", "World");
    }

    @Test
    void string_lines_with_carriage_return_and_newline_and_carriage_return_and_newline() {
        Stream<String> lines = "Hello\r\n\r\nWorld".lines();

        assertThat(lines).containsExactly("Hello", "", "World");
    }

    @Test
    void string_repeats() {
        String value = "1".repeat(10);

        assertThat(value).isEqualTo("1111111111");
    }

    @Test
    void string_repeats_with_zero() {
        String value = "1".repeat(0);

        assertThat(value).isEqualTo("");
    }

    @Test
    void string_repeats_with_negative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> "1".repeat(-10));
    }

    @Test
    void string_strips() {
        String value = "Hello World".strip();

        assertThat(value).isEqualTo("Hello World");
    }

    @Test
    void string_strips2() {
        String value = " Hello World ".strip();

        assertThat(value).isEqualTo("Hello World");
    }

    @Test
    void string_stripLeading1() {
        String value = " Hello World ".stripLeading();
        
        assertThat(value).isEqualTo("Hello World ");
    }

    @Test
    void string_stripTrailing1() {
        String value = " Hello World ".stripTrailing();

        assertThat(value).isEqualTo(" Hello World");
    }

    @Test
    void string_trim1() {
        String value = " Hello World ".trim();

        assertThat(value).isEqualTo("Hello World");
    }

    @Test
    void string_indexOf() {
        int index = "Hello World".indexOf('o');

        assertThat(index).isEqualTo(4);
    }

    @Test
    void string_indexOf_with_offset() {
        int index = "Hello World".indexOf('o', 5);

        assertThat(index).isEqualTo(7);
    }
}
