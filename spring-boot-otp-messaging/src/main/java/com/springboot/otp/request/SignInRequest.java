
package com.springboot.otp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

	@NotNull
	private String email;

	@NotNull
	private String password;

	@Override
	public String toString() {
		return "SignInRequest{" + "email='" + email + '\'' + ", password='" + password + '\'' + '}';
	}
}
