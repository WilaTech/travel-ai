package com.wilatech.travelai.messenger.client;

import com.wilatech.travelai.messenger.exception.MessengerClientException;
import com.wilatech.travelai.messenger.properties.MessengerProperties;
import com.wilatech.travelai.messenger.send.dto.Message;
import com.wilatech.travelai.messenger.send.dto.Recipient;
import com.wilatech.travelai.messenger.send.dto.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Component
public class MessengerClientImpl implements MessengerClient {

    private final RestClient messengerRestClient;
    private final MessengerProperties messengerProperties;

    @Override
    public void sendMessage(String recipientId, String message) {

        try {
            SendMessageRequest request = new SendMessageRequest(new Recipient(recipientId), new Message(message));
            messengerRestClient.post().body(request).retrieve().toBodilessEntity();
        } catch (Exception e) {
            throw new MessengerClientException("Failed to send message.", e);
        }
    }
}
