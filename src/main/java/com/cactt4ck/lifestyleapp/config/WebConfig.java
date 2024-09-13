package com.cactt4ck.lifestyleapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Appliquer à toutes les routes
                        .allowedOrigins("*") // Autoriser toutes les origines
                        .allowedMethods("*") // Autoriser toutes les méthodes (GET, POST, etc.)
                        .allowedHeaders("*"); // Autoriser tous les headers
            }
        };
    }
}
