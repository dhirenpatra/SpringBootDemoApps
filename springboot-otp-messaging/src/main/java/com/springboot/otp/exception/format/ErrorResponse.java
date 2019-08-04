
package com.springboot.otp.exception.format;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private String errorCode;
	private Instant timeOfOccureance;
	private List<Error> errors;
	private HttpStatus httpStatus;
	private String errorPath;

	@Override
	public String toString() {
		return "ErrorResponse{" +
				"errorCode='" + errorCode + '\'' +
				", timeOfOccureance=" + timeOfOccureance +
				", errors=" + errors +
				", httpStatus=" + httpStatus +
				", errorPath='" + errorPath + '\'' +
				'}';
	}
}
