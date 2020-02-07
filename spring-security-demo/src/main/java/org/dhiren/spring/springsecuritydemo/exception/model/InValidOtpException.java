package org.dhiren.spring.springsecuritydemo.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InValidOtpException extends ResponseStatusException {

    private Enum errorCode;

    public InValidOtpException(HttpStatus status) {
        super(status);
    }

    public InValidOtpException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public InValidOtpException(HttpStatus status, String reason, Enum errorCode) {
        super(status, reason);
        this.errorCode = errorCode;
    }

    public InValidOtpException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public Enum getErrorCode() {
        return errorCode;
    }
}
