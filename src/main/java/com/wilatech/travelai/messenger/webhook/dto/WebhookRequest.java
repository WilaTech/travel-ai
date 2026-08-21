package com.wilatech.travelai.messenger.webhook.dto;

import java.util.List;

public record WebhookRequest(
        String object,
        List<Entry> entry
) {
}
