package com.wilatech.travelai.messenger.service;

import com.wilatech.travelai.messenger.client.MessengerClient;
import com.wilatech.travelai.messenger.webhook.dto.WebhookRequest;
import com.wilatech.travelai.travel.service.TravelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessengerWebhookService {

    private final MessengerClient messengerClient;

    private final TravelService travelService;

    public void process(WebhookRequest request) {
        var messaging = request.entry().getFirst().messaging().getFirst();

        String senderId = messaging.sender().id();
        String message = messaging.message().text();

        log.info("Sender: {}", senderId);
        log.info("Message: {}", message);

        String reply = travelService.getRecommendation(message);
        if (reply.length() > 2000) {
            reply = reply.substring(0, 2000);
        }
        messengerClient.sendMessage(senderId, reply);
    }
}
