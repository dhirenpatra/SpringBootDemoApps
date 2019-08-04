
package com.springboot.otp.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

	@NotNull
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@NotNull
	@JsonProperty("email")
	private String email;

	@NotNull
	@JsonProperty("password")
	private String password;

	@Override
	public String toString() {
		return "SignupRequest{" + "phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\''
		        + ", password='" + password + '\'' + '}';
	}
}
