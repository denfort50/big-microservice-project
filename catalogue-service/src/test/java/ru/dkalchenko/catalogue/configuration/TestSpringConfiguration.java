package ru.dkalchenko.catalogue.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestSpringConfiguration {

    @Bean
    public JwtDecoder jwtCoder() {
        return mock(JwtDecoder.class);
    }
}
