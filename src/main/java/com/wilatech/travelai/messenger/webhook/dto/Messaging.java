package com.wilatech.travelai.messenger.webhook.dto;

public record Messaging(
        Sender sender,
        Recipient recipient,
        Message message
) {
}
