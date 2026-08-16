package com.wilatech.travelai.client;

import com.wilatech.travelai.dto.gemini.Content;
import com.wilatech.travelai.dto.gemini.GeminiRequest;
import com.wilatech.travelai.dto.gemini.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
@Component
@Primary
public class GeminiClient implements AIClient {

    private final RestClient geminiRestClient;

    @Override
    public String chat(String prompt) {
        var request = new GeminiRequest(List.of(new Content(List.of(new Part(prompt)))));
        return "";
    }
}
