package com.example.reactive.redis;

import javax.annotation.PostConstruct;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

/**
 * 咖啡缓存加载器。
 * 缓存预热
 * 3.Create a Spring Bean to load some sample data to our application when we start it.
 *
 * @author guangyi
 * @since 2022-02-04
 */
@SuppressWarnings("unused")
@Component("coffeeLoader")
public class CoffeeLoader {

    private final ReactiveRedisConnectionFactory connectionFactory;
//    private final ReactiveRedisOperations<String, Coffee> redisOperations;
    private final ReactiveRedisOperations<String, String> stringOperations;

    public CoffeeLoader(
            ReactiveRedisConnectionFactory connectionFactory,
//            ReactiveRedisOperations<String, Coffee> redisOperations,
            ReactiveRedisOperations<String, String> stringOperations
    ) {
        this.connectionFactory = connectionFactory;
//        this.redisOperations = redisOperations;
        this.stringOperations = stringOperations;
    }

    @PostConstruct
    public void loadData() {
        // string-字符串
        connectionFactory.getReactiveConnection()
                .serverCommands()
                .flushAll()
                .then(stringOperations.opsForValue()
                        .set("stringKey", "stringValue", Duration.ofDays(1L))
                )
                .then(stringOperations.opsForValue()
                        .get("stringKey")
                        .map(value -> "stringKey: " + value)
                )
                .subscribe(System.out::println);

        // set-集合
        connectionFactory.getReactiveConnection()
                .serverCommands()
                .flushAll()
                .then(stringOperations.opsForSet()
                        .add("setKey", "setValue1", "setValue2", "setValue3")
                )
                .then(stringOperations.opsForSet()
                        .members("setKey")
                        .collectList()
                        .map(values -> "setKey: " + values)
                )
                .subscribe(System.out::println);

        // hash-散列表
        Map<String, String> personMap = new HashMap<>(16);
        personMap.put("name", "Edward Lee");
        personMap.put("id", "369");
        connectionFactory.getReactiveConnection()
                .serverCommands()
                .flushAll()
                .then(stringOperations.opsForHash()
                        .putAll("hashKey", personMap)
                )
                .then(stringOperations.opsForHash()
                        .multiGet("hashKey", Arrays.asList("name", "id"))
                        .map(values -> "hashKey: " + values)
                )
                .subscribe(System.out::println);

//        connectionFactory.getReactiveConnection()
//                .serverCommands()
//                .flushAll()
//                .thenMany(Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
//                        .map(name -> new Coffee(UUID.randomUUID().toString(), name))
//                        .flatMap(coffee -> redisOperations.opsForValue().set(coffee.getId(), coffee))
//                )
//                .thenMany(redisOperations.keys("*")
//                        .flatMap(redisOperations.opsForValue()::get)
//                )
//                .subscribe(System.out::println);
    }
}
