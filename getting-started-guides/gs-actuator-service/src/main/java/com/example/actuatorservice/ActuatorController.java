package com.example.actuatorservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 执行器API控制器。
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SuppressWarnings("unused")
@RestController("actuatorController")
public class ActuatorController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(0L);

    @GetMapping("/hello")
    @ResponseBody
    public Greeting sayHello(
            @RequestParam(name="name", required=false, defaultValue="World") String name
    ) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
