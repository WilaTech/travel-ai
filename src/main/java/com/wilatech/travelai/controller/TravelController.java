package com.wilatech.travelai.controller;

import com.wilatech.travelai.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/api/travel")
    public String travel(@RequestParam String location) {
        return travelService.getRecommendation(location);
    }
}
