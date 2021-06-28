package com.yugotcha.gameplanet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("Authorization", "Content-Type")
                .allowedOrigins("*")
                .allowedHeaders("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
    }
}
