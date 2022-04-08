package com.rebwon.toy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

class Dispatch {
    public String method() {
        return "Hello Spring";
    }
}

class DispatchImpl implements DynamicDispatch {

    @Override
    public String some() {
        return "Hello Dispatch";
    }
}

interface DynamicDispatch {
    String some();
}