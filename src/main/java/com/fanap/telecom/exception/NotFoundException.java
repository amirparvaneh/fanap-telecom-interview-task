package com.fanap.telecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    private final long serialUid = -532453252352353l;
    public NotFoundException(String message) {
        super(message);
    }
}
