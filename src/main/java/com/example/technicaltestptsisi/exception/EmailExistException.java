package com.example.technicaltestptsisi.exception;


public class EmailExistException extends RuntimeException {
    private final String message;

    public EmailExistException(String message) {
        super(message);
        this.message = message;
    }
}
