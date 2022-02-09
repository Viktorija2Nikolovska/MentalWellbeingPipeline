package com.ukim.finki.mentalwellbeing.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PsychiatristsNotFoundException extends RuntimeException {

    public PsychiatristsNotFoundException(Long id){
        super(String.format("Psychiatrist with id %s was not found", id));
    }
}



