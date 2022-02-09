package com.ukim.finki.mentalwellbeing.model.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(){
        super("Invalid user credentials");
    }
}
