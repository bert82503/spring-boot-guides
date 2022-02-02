package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

/**
 * Test of {@link HelloController}.
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerRestTest {

    private final TestRestTemplate testRestTemplate;

    @Autowired
    public HelloControllerRestTest(
            TestRestTemplate testRestTemplate
    ) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    void getHello() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/", String.class);
        assertThat(responseEntity.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}
