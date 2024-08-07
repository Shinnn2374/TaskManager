package com.example.TaskManager.Swagger;

import org.springframework.context.annotation.Bean;

public class SwaggerConfig
{
    @Bean
    public OpenApi customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Task Management API").version("1.0"));
    }
}
