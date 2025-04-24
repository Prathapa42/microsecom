package com.productservices.Productservices.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Productconfig {


    @Bean
    public OpenAPI myproductOpenAPI() {
            // Define your OpenAPI configuration here
            return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info().title("Product Service API")
                   .version("1.0")
                   .description("API for managing products")
                    .contact(new io.swagger.v3.oas.models.info.Contact().name("API Support")
                           .url("https://example.com/support")
                           .email("support@example.com")))
                   .servers(Arrays.asList(new Server().url("http://localhost:8081").description("Local Server")
                           ,new Server().url("http://localhost:8081/api/products").description("UAT Server")));
    }


}
