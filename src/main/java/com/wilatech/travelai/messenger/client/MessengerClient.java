package com.wilatech.travelai.messenger.client;

public interface MessengerClient {

    void sendMessage(String recipientId, String message);
}
