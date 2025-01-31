# Getting Started

### Using Swagger 3 - OpenAPI
For Spring Boot 3.x, you need to use SpringDoc instead of SpringFox since SpringFox is not maintained anymore.

* Add SpringDoc dependencies:
* ```implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0'```

* Update your configuration:
* ```declarative
  @Configuration
  public class OpenAPIConfiguration {
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Spring Boot 3.x REST API")
                            .version("1.0")
                            .description("Spring Boot 3.x REST API using SpringDoc"));
        }
    }
    ```
* Access Swagger UI:
* ```http://localhost:8080/swagger-ui.html```
* Access OpenAPI JSON:
* ```http://localhost:8080/v3/api-docs```
