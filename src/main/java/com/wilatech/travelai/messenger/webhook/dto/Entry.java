package com.wilatech.travelai.messenger.webhook.dto;

import java.util.List;

public record Entry(
        List<Messaging> messaging
) {
}
