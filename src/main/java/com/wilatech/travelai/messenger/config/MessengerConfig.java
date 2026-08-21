package com.wilatech.travelai.messenger.config;

import com.wilatech.travelai.ai.gemini.properties.GeminiProperties;
import com.wilatech.travelai.messenger.properties.MessengerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class MessengerConfig {

    @Bean
    public RestClient messengerRestClient(MessengerProperties properties) {

        return RestClient.builder()
                .baseUrl(properties.apiUrl())
                .defaultHeaders(headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setBearerAuth(properties.pageAccessToken());
                })
                .build();
    }
}
