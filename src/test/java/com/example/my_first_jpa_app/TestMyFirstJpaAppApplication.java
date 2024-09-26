package com.example.my_first_jpa_app;

import org.springframework.boot.SpringApplication;

public class TestMyFirstJpaAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(MyFirstJpaAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
