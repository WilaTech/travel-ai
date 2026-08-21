package com.wilatech.travelai.travel.service;

import com.wilatech.travelai.ai.client.AIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TravelServiceImpl implements TravelService {

    private final AIClient aiClient;

    @Override
    public String getRecommendation(String location) {
        String prompt = "Suggest travel destinations in " + location;
        return aiClient.chat(prompt);
    }
}
