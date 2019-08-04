package com.springboot.otp.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InValidOtpException extends ResponseStatusException {

    public InValidOtpException(HttpStatus status) {
        super(status);
    }

    public InValidOtpException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public InValidOtpException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
