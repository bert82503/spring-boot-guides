package com.example.reactive.redis;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 4.Create a RestController to provide an external interface for our application.
 *
 * @author guangyi
 * @since 2022-02-04
 */
@SuppressWarnings("unused")
@RestController("coffeeController")
public class CoffeeController {

    private final ReactiveRedisOperations<String, Coffee> redisOperations;

    public CoffeeController(
            ReactiveRedisOperations<String, Coffee> redisOperations
    ) {
        this.redisOperations = redisOperations;
    }

    @GetMapping("/coffees")
    public Flux<Coffee> getAll() {
        return redisOperations.keys("*")
                .flatMap(redisOperations.opsForValue()::get);
    }
}
