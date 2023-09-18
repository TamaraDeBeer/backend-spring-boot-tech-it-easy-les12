package com.example.backendspringboottechiteasycontrollerles10.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
    public RecordNotFoundException() {
        super();
    }
}
