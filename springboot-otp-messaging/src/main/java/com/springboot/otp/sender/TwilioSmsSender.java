
package com.springboot.otp.sender;

import java.util.Calendar;
import java.util.Random;

import com.springboot.otp.exception.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.otp.config.TwilioConfig;
import com.springboot.otp.model.OtpModel;
import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.SmsRequest;
import com.springboot.otp.storage.UserStorage;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.validation.constraints.NotNull;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

	private final String MSG_FORMAT = "! Your Verification code is ";

	private TwilioConfig twilioConfig;
	private UserStorage userStorage;

	@Autowired
	public TwilioSmsSender(TwilioConfig twilioConfig, UserStorage userStorage) {
		this.twilioConfig = twilioConfig;
		this.userStorage = userStorage;
	}

	@Override
	public void sendTestMessage(SmsRequest smsRequest) {
		PhoneNumber to = new PhoneNumber(smsRequest.getReceiverPhone());
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		String messageToSend = smsRequest.getMessage();
		Message.creator(to, from, messageToSend)
		        .create();
	}

	@Override
	public void sendSignUpOtp(SignUpRequest signUpRequest, Calendar requestedTime) {
		@NotNull String phoneNumber = signUpRequest.getPhoneNumber();
		OtpModel otpModel = generateAndSendOtp(requestedTime, phoneNumber);
		otpModel.setEmail(signUpRequest.getEmail());
		userStorage.insertPersonDetails(phoneNumber,otpModel);
	}

	@Override
	public void sendSignInOtp(SignInRequest signInRequest, Calendar requestedTime) {
		OtpModel otpModel = userStorage.getPhoneNumber(signInRequest.getEmail());
		if (otpModel != null)
			generateAndSendOtp(requestedTime, otpModel.getPhoneNumber());
		else
			throw new UserNotFoundException(HttpStatus.NOT_FOUND,
				"Requested User is not found ! Please register if you are not already our user");
	}

	private String generateFourDigitCode() {
		return String.format("%04d", new Random().nextInt(10000));
	}

	private String greetings(Calendar calendar) {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		return hour <= 12 && minute > 0 ? "Good Morning" : "Hello";
	}

	private OtpModel generateAndSendOtp(Calendar requestedTime, String phoneNumber) {
		String fourDigitCode = generateFourDigitCode();
		String greeting = greetings(requestedTime);
		String message = greeting + MSG_FORMAT + fourDigitCode;
		System.err.println(message);

		OtpModel otpModel = new OtpModel();
		otpModel.setOtp(fourDigitCode);
		otpModel.setPhoneNumber(phoneNumber);
		otpModel.setExpirationTime(System.currentTimeMillis() + 5000);

		return otpModel;
	}
}
