package com.example.demo.exception;

public class InvalidFiscalCodeException extends RuntimeException{
    public InvalidFiscalCodeException(String message) {
        super(message);
    }
}
