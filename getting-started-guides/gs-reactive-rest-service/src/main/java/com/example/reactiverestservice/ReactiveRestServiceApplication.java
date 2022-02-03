package com.example.reactiverestservice;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 应用程序运行入口。
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SpringBootApplication
public class ReactiveRestServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication
                .run(ReactiveRestServiceApplication.class, args);
        GreetingClient greetingClient = applicationContext.getBean(GreetingClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        String message = greetingClient.getMessage().block(Duration.ofSeconds(1L));
        System.out.println(">> message = " + message);
    }
}
