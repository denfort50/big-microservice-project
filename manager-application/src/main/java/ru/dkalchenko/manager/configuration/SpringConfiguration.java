package ru.dkalchenko.manager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class SpringConfiguration {

    @Bean
    public RestClient restClient(@Value("${catalogue.service.url:http://localhost:8081}") String catalogueServiceUrl,
            @Value("${catalogue.service.username:}") String username,
            @Value("${catalogue.service.password:}") String password) {
        return RestClient.builder()
                .baseUrl(catalogueServiceUrl)
                .requestInterceptor(new BasicAuthenticationInterceptor(username, password))
                .build();
    }
}
