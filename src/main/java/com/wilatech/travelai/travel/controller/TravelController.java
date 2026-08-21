package com.wilatech.travelai.travel.controller;

import com.wilatech.travelai.travel.service.TravelAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TravelController {

    private final TravelAssistantService travelAssistantService;

    @GetMapping("/api/travel")
    public String travel(@RequestParam String location) {
        return travelAssistantService.getRecommendation(location);
    }
}
