package com.example.reactiverestservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 2.Create a Router.
 *
 * @author guangyi
 * @since 2022-02-03
 */
@Configuration(value = "greetingRouter", proxyBeanMethods = false)
public class GreetingRouter {

    @Bean("helloRoute")
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                greetingHandler::hello);
    }
}
