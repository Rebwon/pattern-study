package com.rebwon.stream.fastcampus;

import com.rebwon.stream.fastcampus.model.User;
import org.junit.jupiter.api.Test;

public final class BuilderTests {

    @Test
    void name() {
        User rebwon = User.builder(1, "rebwon")
            .with(builder -> {
                builder.emailAddress = "msolo021015@gmail.com";
                builder.isVerified = true;
            }).build();
        System.out.println(rebwon);
    }
}
