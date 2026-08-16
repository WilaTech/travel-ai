package com.wilatech.travelai.config;

import com.wilatech.travelai.config.properties.GeminiProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class GeminiConfig {

    @Bean
    public RestClient geminiRestClient(GeminiProperties properties) {

        return RestClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-goog-api-key", properties.apiKey())
                .build();
    }
}
