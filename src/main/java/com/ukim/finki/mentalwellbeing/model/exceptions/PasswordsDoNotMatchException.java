package com.ukim.finki.mentalwellbeing.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {

    public PasswordsDoNotMatchException() {
        super("Passwords don't match");
    }
}
