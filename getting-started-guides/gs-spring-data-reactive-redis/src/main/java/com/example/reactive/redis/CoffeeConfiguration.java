package com.example.reactive.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 咖啡redis缓存配置。
 * 2.Create a configuration class with Spring Beans supporting reactive Redis operations.
 *
 * @author guangyi
 * @since 2022-02-04
 */
@Configuration("coffeeConfiguration")
public class CoffeeConfiguration {

    @Bean
    public ReactiveRedisOperations<String, Coffee> redisOperations(
            ReactiveRedisConnectionFactory connectionFactory
    ) {
        Jackson2JsonRedisSerializer<Coffee> serializer =
                new Jackson2JsonRedisSerializer<>(Coffee.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Coffee> serializationContextBuilder =
                RedisSerializationContext.newSerializationContext(StringRedisSerializer.UTF_8);
        RedisSerializationContext<String, Coffee> serializationContext =
                serializationContextBuilder.value(serializer).build();
        return new ReactiveRedisTemplate<>(
                connectionFactory, serializationContext);
    }

    @Bean
    public ReactiveRedisOperations<String, String> stringOperations(
            ReactiveRedisConnectionFactory connectionFactory
    ) {
        Jackson2JsonRedisSerializer<String> serializer =
                new Jackson2JsonRedisSerializer<>(String.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, String> serializationContextBuilder =
                RedisSerializationContext.newSerializationContext(StringRedisSerializer.UTF_8);
        RedisSerializationContext<String, String> serializationContext =
                serializationContextBuilder.value(serializer).build();
        return new ReactiveRedisTemplate<>(
                connectionFactory, serializationContext);
    }
}
