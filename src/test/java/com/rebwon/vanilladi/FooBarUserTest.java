package com.rebwon.vanilladi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FooBarUserTest {

    // 상태(state) 검증
    @Test
    void sociableTest() {
        // Arrange
        var sut = new FooBarUser(new Foo(), new Bar());

        // Act
        Throwable throwable = catchThrowable(sut::danceWithDependencies);

        // Assert
        assertThat(throwable).isNull();
    }

    // 행위(behavior) 검증
    @Test
    void solitaryTest() {
        // Arrange
        var barSpy = new BarSpy();
        var sut = new FooBarUser(new FooStub(1234), barSpy);

        // Act
        sut.danceWithDependencies();

        // Assert
        assertThat(barSpy.getCalledArgs()).containsExactly(1234);
    }
}