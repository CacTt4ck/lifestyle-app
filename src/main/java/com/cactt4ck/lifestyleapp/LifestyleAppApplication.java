package com.cactt4ck.lifestyleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LifestyleAppApplication {

    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(LifestyleAppApplication.class, args);
    }
}
