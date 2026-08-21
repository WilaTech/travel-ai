package com.wilatech.travelai.messenger.controller;

import com.wilatech.travelai.messenger.properties.MessengerProperties;
import com.wilatech.travelai.messenger.service.MessengerWebhookService;
import com.wilatech.travelai.messenger.webhook.dto.WebhookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/webhook")
@Slf4j
public class MessengerWebhookController {

    private final MessengerProperties messengerProperties;

    private final MessengerWebhookService messengerWebhookService;

    @GetMapping
    public ResponseEntity<String> verify(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String verifyToken,
            @RequestParam("hub.challenge") String challenge) {

        log.info("Messenger verification request. mode={}", mode);
        if ("subscribe".equals(mode) && messengerProperties.verifyToken().equals(verifyToken)) {
            return ResponseEntity.ok(challenge);
        }

        log.warn("Messenger verification failed.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping
    public ResponseEntity<Void> webhook(@RequestBody WebhookRequest request) {
        log.info("Received webhook");

        messengerWebhookService.process(request);

        return ResponseEntity.ok().build();
    }
}
