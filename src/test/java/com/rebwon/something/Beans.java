package com.rebwon.something;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Beans {

    static {
        System.out.println("I am loaded!");
    }
}
