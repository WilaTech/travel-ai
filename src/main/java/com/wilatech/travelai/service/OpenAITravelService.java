package com.wilatech.travelai.service;

public class OpenAITravelService implements TravelService {

    @Override
    public String getRecommendation(String location) {
        return "Recommended places in " + location;
    }
}
