package com.rebwon.app;

import com.rebwon.app.infrastructure.NotificationEventHandler;
import com.rebwon.app.infrastructure.NotificationRepositoryAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Import(value = {
        NotificationEventHandler.class,
        NotificationRepositoryAdapter.class
    })
    @Configuration
    public static class NotificationModuleConfiguration {

    }
}