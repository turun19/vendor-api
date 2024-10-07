package com.example.technicaltestptsisi.exception;

public class UsernameExistException extends RuntimeException{
    private final String message;

    public UsernameExistException(String message) {
        super(message);
        this.message = message;
    }
}
