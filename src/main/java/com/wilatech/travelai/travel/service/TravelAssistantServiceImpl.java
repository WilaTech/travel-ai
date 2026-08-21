package com.wilatech.travelai.travel.service;

import com.wilatech.travelai.ai.client.AIClient;
import com.wilatech.travelai.travel.prompt.TravelPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TravelAssistantServiceImpl implements TravelAssistantService {

    private final TravelPromptBuilder promptBuilder;
    private final AIClient aiClient;


    @Override
    public String getRecommendation(String location) {
        String prompt =
                promptBuilder.buildRecommendationPrompt(location);

        return aiClient.chat(prompt);
    }
}
