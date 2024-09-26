package com.example.my_first_jpa_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MyFirstJpaAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
