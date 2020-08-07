
package org.dhiren.spring.springsecuritydemo.exception.format;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private String errorCode;
	private Instant timeOfOccurrence;
	private List<Error> errors;
	private HttpStatus httpStatus;
	private String errorPath;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Instant getTimeOfOccurrence() {
		return timeOfOccurrence;
	}

	public void setTimeOfOccurrence(Instant timeOfOccurrence) {
		this.timeOfOccurrence = timeOfOccurrence;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorPath() {
		return errorPath;
	}

	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}

	@Override
	public String toString() {
		return "ErrorResponse{" +
				"errorCode='" + errorCode + '\'' +
				", timeOfOccurrence=" + timeOfOccurrence +
				", errors=" + errors +
				", httpStatus=" + httpStatus +
				", errorPath='" + errorPath + '\'' +
				'}';
	}
}
