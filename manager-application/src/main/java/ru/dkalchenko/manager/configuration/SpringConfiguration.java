package ru.dkalchenko.manager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestClient;
import ru.dkalchenko.manager.security.OAuthClientHttpRequestInterceptor;

@Configuration
public class SpringConfiguration {

    @Bean
    public RestClient restClient(@Value("${catalogue.service.url:http://localhost:8081}") String catalogueServiceUrl,
                                 ClientRegistrationRepository clientRegistrationRepository,
                                 OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository,
                                 @Value("${catalogue.service.registration-id:keycloak}") String registrationId) {
        return RestClient.builder()
                .baseUrl(catalogueServiceUrl)
                .requestInterceptor(new OAuthClientHttpRequestInterceptor(
                        new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,
                                oAuth2AuthorizedClientRepository), registrationId
                ))
                .build();
    }
}
