package com.rebwon.vanilladi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Vanilla Di")
class FooBarUserTest {

    @Test
    @DisplayName("상태 기반 검증 with Classicist")
    void sociableTest() {
        // Arrange
        var sut = new FooBarUser(new Foo(), new Bar());

        // Act
        Throwable throwable = catchThrowable(sut::danceWithDependencies);

        // Assert
        assertThat(throwable).isNull();
    }

    @Test
    @DisplayName("행위 기반 검증 Mockist")
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