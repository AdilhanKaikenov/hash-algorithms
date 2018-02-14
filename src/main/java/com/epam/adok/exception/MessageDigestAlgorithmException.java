package com.epam.adok.exception;

public class MessageDigestAlgorithmException extends RuntimeException {

    public MessageDigestAlgorithmException(String message) {
        super(message);
    }

    public MessageDigestAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
