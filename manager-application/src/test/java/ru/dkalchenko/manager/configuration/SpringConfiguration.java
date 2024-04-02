package ru.dkalchenko.manager.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestClient;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class SpringConfiguration {

    @Bean
    public ClientRegistrationRepository clientRegistration() {
        return mock(ClientRegistrationRepository.class);
    }

    @Bean
    public OAuth2AuthorizedClientRepository oAuth2AuthorizedClient() {
        return mock(OAuth2AuthorizedClientRepository.class);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
