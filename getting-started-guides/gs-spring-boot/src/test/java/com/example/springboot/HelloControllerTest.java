package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Test of {@link HelloController}.
 *
 * @author guangyi
 * @since 2022-02-03
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    public HelloControllerTest(
            MockMvc mockMvc
    ) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getHello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Greetings from Spring Boot!"));
    }
}
