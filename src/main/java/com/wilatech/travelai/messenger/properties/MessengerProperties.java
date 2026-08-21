package com.wilatech.travelai.messenger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "messenger")
public record MessengerProperties(
        String verifyToken,
        String pageAccessToken,
        String apiUrl
) {
}
