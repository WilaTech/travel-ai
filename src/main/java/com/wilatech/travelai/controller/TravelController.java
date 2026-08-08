package com.wilatech.travelai.controller;

import com.wilatech.travelai.service.TravelService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }
}
