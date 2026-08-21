package com.wilatech.travelai.messenger.exception;

public class MessengerClientException extends RuntimeException {

    public MessengerClientException(String message) {
        super(message);
    }

    public MessengerClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
