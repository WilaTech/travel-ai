package com.wilatech.travelai.service;

import com.wilatech.travelai.client.AIClient;
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
