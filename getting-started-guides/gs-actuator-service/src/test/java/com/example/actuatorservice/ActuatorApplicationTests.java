package com.example.actuatorservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test of {@link ActuatorApplication}.
 *
 * @author guangyi
 * @since 2022-02-04
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class ActuatorApplicationTests {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int managementPort;

    private final TestRestTemplate testRestTemplate;

    @Autowired
    public ActuatorApplicationTests(
            TestRestTemplate testRestTemplate
    ) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    public void shouldReturn200WhenSendingRequestToController() {
        ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/hello", String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("{\"id\":1,\"content\":\"Hello, World!\"}");
    }

    @Test
    public void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.managementPort + "/actuator/health", String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("{\"status\":\"UP\"}");
    }
}
