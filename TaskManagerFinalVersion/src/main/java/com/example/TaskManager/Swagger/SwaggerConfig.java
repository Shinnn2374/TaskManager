package com.example.TaskManager.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Task Management API", version = "1.0"))
@Configuration
public class SwaggerConfig
{
    @Bean
    public String customOpenAPI() {
        return "Task Management API: version 1.0";
    }
}
