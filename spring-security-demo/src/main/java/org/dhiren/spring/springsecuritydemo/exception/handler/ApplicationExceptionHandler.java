
package org.dhiren.spring.springsecuritydemo.exception.handler;

import org.dhiren.spring.springsecuritydemo.exception.format.Error;
import org.dhiren.spring.springsecuritydemo.exception.format.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Arrays;

import static org.dhiren.spring.springsecuritydemo.utils.ApplicationConstants.BAD_REQUEST;
import static org.dhiren.spring.springsecuritydemo.utils.ApplicationConstants.REQUEST_FIELD_ERROR;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object>
	          handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
	                                       HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = getErrorResponse(ex,status,BAD_REQUEST.name());
        errorResponse.setErrorPath(request.getContextPath());
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            errorResponse.setErrors(Arrays.asList(
                    new Error(REQUEST_FIELD_ERROR.name(),fieldError.getDefaultMessage(),fieldError.getField())
            ));
        }
		return this.handleExceptionInternal(ex, (Object) errorResponse, headers, status, request);
	}

	private ErrorResponse getErrorResponse(Exception ex, HttpStatus status, String errorCode) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorCode);
        errorResponse.setTimeOfOccurrence(Instant.now());
        errorResponse.setHttpStatus(status);
        return errorResponse;
    }

}
