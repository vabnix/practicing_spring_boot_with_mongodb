package com.vaibhav.spring.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD - Connecting to MongoDB")
                        .description("Spring Boot Application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Vaibhav Srivastava")
                                .url("http://ish-aum.com")
                                .email("info@ish-aum.com")));
    }
}