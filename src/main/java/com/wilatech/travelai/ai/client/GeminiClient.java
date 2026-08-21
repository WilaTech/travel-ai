package com.wilatech.travelai.ai.client;

import com.wilatech.travelai.ai.gemini.properties.GeminiProperties;
import com.wilatech.travelai.ai.gemini.dto.GeminiResponse;
import com.wilatech.travelai.ai.gemini.dto.RequestContent;
import com.wilatech.travelai.ai.gemini.dto.GeminiRequest;
import com.wilatech.travelai.ai.gemini.dto.RequestPart;
import com.wilatech.travelai.ai.exception.AIClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RequiredArgsConstructor
@Component
@Primary
public class GeminiClient implements AIClient {

    private final RestClient geminiRestClient;
    private final GeminiProperties properties;

    @Override
    public String chat(String prompt) {
        var request = new GeminiRequest(List.of(new RequestContent(List.of(new RequestPart(prompt)))));

        GeminiResponse response = null;
        try {
            String endpoint =
                    "/models/%s:generateContent".formatted(properties.model());
            response = geminiRestClient.post()
                    .uri(endpoint)
                    .body(request)
                    .retrieve()
                    .body(GeminiResponse.class);
        } catch (RestClientException e) {
            throw new AIClientException("Failed to call Gemini API.", e);
        }

        return extractText(response);
    }

    private String extractText(GeminiResponse response) {
        if (response == null) {
            throw new AIClientException("No response received from Gemini.");
        }

        if (response.candidates() == null || response.candidates().isEmpty()) {
            throw new AIClientException("Gemini returned no candidates.");
        }

        var candidate = response.candidates().getFirst();
        if (candidate.content() == null) {
            throw new AIClientException("Gemini candidate contains no content.");
        }

        var content = candidate.content();
        if (content.parts() == null || content.parts().isEmpty()) {
            throw new AIClientException("Gemini content contains no parts.");
        }

        var part = content.parts().getFirst();
        if (part.text() == null || part.text().isBlank()) {
            throw new AIClientException("Gemini returned an empty response.");
        }

        return part.text();
    }
}
