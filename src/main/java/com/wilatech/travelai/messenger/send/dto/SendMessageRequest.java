package com.wilatech.travelai.messenger.send.dto;

public record SendMessageRequest(
        Recipient recipient,
        Message message) {
}
