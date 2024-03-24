package ru.dkalchenko.manager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SpringConfiguration {

    @Bean
    public RestClient restClient(@Value("${catalogue.service.url:http://localhost:8081}") String catalogueServiceUrl) {
        return RestClient.builder()
                .baseUrl(catalogueServiceUrl)
                .build();
    }
}
