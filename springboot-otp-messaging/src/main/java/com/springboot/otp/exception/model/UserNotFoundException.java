package com.springboot.otp.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    private Enum errorCode;

    public UserNotFoundException(HttpStatus status) {
        super(status);
    }

    public UserNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public UserNotFoundException(HttpStatus status, String reason, Enum errorCode) {
        super(status, reason);
        this.errorCode = errorCode;
    }

    public UserNotFoundException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public Enum getErrorCode() {
        return errorCode;
    }
}
