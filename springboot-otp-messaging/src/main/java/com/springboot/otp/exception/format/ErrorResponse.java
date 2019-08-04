
package com.springboot.otp.exception.format;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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
