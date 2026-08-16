package com.wilatech.travelai.client;

import org.springframework.stereotype.Component;

@Component
public class GeminiClient implements AIClient {
    @Override
    public String chat(String prompt) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
