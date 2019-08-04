
package com.springboot.otp.exception.handler;

import static com.springboot.otp.utils.ApplicationConstants.BAD_REQUEST;
import static com.springboot.otp.utils.ApplicationConstants.METHOD_NOT_SUPPORTED;
import static com.springboot.otp.utils.ApplicationConstants.REQUEST_FIELD_ERROR;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import com.springboot.otp.exception.format.Error;
import com.springboot.otp.exception.model.InValidOtpException;
import com.springboot.otp.exception.model.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.otp.exception.format.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object>
	       handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
	                                           HttpHeaders headers, HttpStatus status,
	                                           WebRequest request) {
		pageNotFoundLogger.warn(ex.getMessage());
		Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
		if (!CollectionUtils.isEmpty(supportedMethods)) {
			headers.setAllow(supportedMethods);
		}
		ErrorResponse errorResponse = getErrorResponse(ex,status,METHOD_NOT_SUPPORTED.name());
		errorResponse.setErrorPath(request.getContextPath());
        errorResponse.setErrors(Arrays.asList(
                new Error(METHOD_NOT_SUPPORTED.name(),ex.getMessage())
        ));
		return this.handleExceptionInternal(ex, (Object) errorResponse, headers, status, request);
	}

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

    @ExceptionHandler(InValidOtpException.class)
    protected ResponseEntity<Object> handleInValidOtpException(InValidOtpException ex) {
		ErrorResponse errorResponse = getErrorResponse(ex,ex.getStatus(),ex.getErrorCode().name());
		errorResponse.setErrors(
				Arrays.asList(new Error(ex.getErrorCode().name(), ex.getReason()))
		);
		return ResponseEntity.status(ex.getStatus()).body(errorResponse);
	}

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleInValidOtpException(UserNotFoundException ex) {
		ErrorResponse errorResponse = getErrorResponse(ex,ex.getStatus(),ex.getErrorCode().name());
		errorResponse.setErrors(
				Arrays.asList(new Error(ex.getErrorCode().name(), ex.getReason()))
		);
		return ResponseEntity.status(ex.getStatus()).body(errorResponse);
	}

}
