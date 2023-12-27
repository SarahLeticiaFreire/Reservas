package com.example.demo.infra.exceptions;

public class AnfitriaoNotFoundException extends RuntimeException {
    public AnfitriaoNotFoundException(String message) {
        super(message);
    }
}