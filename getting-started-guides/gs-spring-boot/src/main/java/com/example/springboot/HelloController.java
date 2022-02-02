package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问候API控制器。
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SuppressWarnings("unused")
@RestController("helloController")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
