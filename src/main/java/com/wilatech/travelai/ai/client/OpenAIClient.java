package com.wilatech.travelai.ai.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class OpenAIClient implements AIClient {

    private final RestClient openAIRestClient;

    @Override
    public String chat(String prompt) {
        Map<String, Object> request = Map.of(
                "model", "gpt-4o-mini",
                "messages", new Object[]{
                        Map.of("role", "user", "content", prompt)
                }
        );

        Map response = openAIRestClient.post()
                .uri("/chat/completions")
                .body(request)
                .retrieve()
                .body(Map.class);

        var choices = (java.util.List<Map>) response.get("choices");
        var message = (Map) choices.get(0).get("message");

        return message.get("content").toString();
    }
}