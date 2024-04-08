package ru.dkalchenko.manager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@TestConfiguration
public class TestSpringConfiguration {

    @Bean
    public RestClient restClient(@Value("${catalogue.service.url:http://localhost:54321}")
                                     String catalogueServiceUrl) {
        return RestClient.builder()
                .baseUrl(catalogueServiceUrl)
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();
    }
}
