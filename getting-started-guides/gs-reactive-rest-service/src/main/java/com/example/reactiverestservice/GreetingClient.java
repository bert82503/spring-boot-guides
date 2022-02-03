package com.example.reactiverestservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * 3.Create a WebClient.
 *
 * @author guangyi
 * @since 2022-02-03
 */
@Component("greetingClient")
public class GreetingClient {

    private final WebClient webClient;

    /**
     * Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
     * We can use it to create a dedicated `WebClient` for our component.
     */
    public GreetingClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getMessage() {
        return this.webClient.get()
                .uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }
}
