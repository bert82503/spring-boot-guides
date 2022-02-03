package com.example.reactiverestservice;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.*;

/**
 * Test of {@link GreetingRouter}.
 *
 * @author guangyi
 * @since 2022-02-03
 */
@ExtendWith(SpringExtension.class)
//  We create a `@SpringBootTest`, starting an actual server on a `RANDOM_PORT`
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRouterTest {

    /**
     * Spring Boot will create a `WebTestClient` for you,
     * already configure and ready to issue requests against "localhost:RANDOM_PORT"
     */
    @Resource
    private WebTestClient webTestClient;
//    private final WebTestClient webTestClient;
//
//    @Autowired
//    public GreetingRouterTest(WebTestClient webTestClient) {
//        this.webTestClient = webTestClient;
//    }

    @Test
    public void hello() {
        // Create a GET request to test an endpoint
        this.webTestClient.get()
                .uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus().isOk()
                .expectBody(Greeting.class)
                .value(greeting -> assertThat(greeting.getMessage()).isEqualTo("Hello, Spring Boot!"));
    }
}
