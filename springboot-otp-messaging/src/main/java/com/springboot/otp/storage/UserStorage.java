
package com.springboot.otp.storage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.springboot.otp.exception.model.InValidOtpException;
import com.springboot.otp.exception.model.UserNotFoundException;
import com.springboot.otp.model.OtpModel;

@Component
public class UserStorage {

	private Map<String, OtpModel> personMap = new HashMap<>();

	public Map<String, OtpModel> insertPersonDetails(String phoneNumber, OtpModel otp) {
		personMap.put(phoneNumber, otp);
        System.err.println(personMap);
		return personMap;
	}

	public OtpModel getPhoneNumber(String email) {
		return personMap.values()
		        .stream()
		        .filter(otpModel -> email.equals(otpModel.getEmail()))
		        .findAny()
		        .orElse(null);
	}

	public boolean findPhoneNumber(String phoneNumber) {
		return personMap.containsKey(phoneNumber);
	}

	public void findAndDelete(String phoneNumber, String otpEntered) {
		if (findPhoneNumber(phoneNumber)) {
			String otpRetrieved = personMap.get(phoneNumber)
			        .getOtp();
			if (otpEntered.equals(otpRetrieved))
				personMap.remove(phoneNumber);
			else
				throw new InValidOtpException(HttpStatus.FORBIDDEN, "Entered OTP is incorrect");
		} else {
			throw new UserNotFoundException(HttpStatus.NOT_FOUND,
			                                "Requested User is not found ! Please register if you are not already our user");
		}
	}

}
