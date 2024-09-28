package com.example.my_first_jpa_app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MyFirstJpaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstJpaAppApplication.class, args);
    }

}
