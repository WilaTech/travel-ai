package com.wilatech.travelai.travel.prompt;

import org.springframework.stereotype.Component;

@Component
public class TravelPromptBuilder {

    public String buildRecommendationPrompt(String userMessage) {
        return TravelPromptTemplate.SYSTEM_PROMPT.formatted(userMessage);
    }

}
