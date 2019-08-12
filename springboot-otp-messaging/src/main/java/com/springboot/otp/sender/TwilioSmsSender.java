
package com.springboot.otp.sender;

import static com.springboot.otp.utils.ApplicationConstants.INVALID_OTP_ENTERED;
import static com.springboot.otp.utils.ApplicationConstants.OTP_EXPIRED;
import static com.springboot.otp.utils.ApplicationConstants.OTP_NOTFOUND;
import static com.springboot.otp.utils.ApplicationConstants.USER_NOT_REGISTERED;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.springboot.otp.utils.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.otp.config.TwilioConfig;
import com.springboot.otp.exception.model.InValidOtpException;
import com.springboot.otp.exception.model.UserNotFoundException;
import com.springboot.otp.model.OtpModel;
import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.SmsRequest;
import com.springboot.otp.request.VerifyOtpRequest;
import com.springboot.otp.storage.UserStorage;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

	@Value("${otp.expiration.time}")
	private Integer otpExpityTime;

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
		otpModel.setUserType(UserType.INITIAL);
		userStorage.insertPersonDetails(phoneNumber,otpModel);
	}

	@Override
	public void sendSignInOtp(SignInRequest signInRequest, Calendar requestedTime) {
		OtpModel otpModelRetrieved = userStorage.getPhoneNumber(signInRequest.getEmail());
		if (otpModelRetrieved != null) {
			OtpModel otpModel = generateAndSendOtp(requestedTime, otpModelRetrieved.getPhoneNumber());
			otpModel.setEmail(signInRequest.getEmail());
			otpModel.setUserType(UserType.VERIFIED);
			userStorage.insertPersonDetails(otpModelRetrieved.getPhoneNumber(),otpModel);
		}
		else
			throw new UserNotFoundException(HttpStatus.NOT_FOUND,
				"Requested User is not found ! Please register if you are not already our user",USER_NOT_REGISTERED);
	}

	@Override
	public void verifyOtp(VerifyOtpRequest otpRequest) {
		OtpModel otpModel = userStorage.getPhoneNumber(otpRequest.getEmail());
		if (otpModel != null)
			checkOtpAreMatched(otpModel,otpRequest.getOtp());
		else
			throw new InValidOtpException(HttpStatus.NOT_FOUND,
					"User otp not found",OTP_NOTFOUND);
	}

	@Override
	public void sendOtpMessage(String phoneNumber, String message) {
		PhoneNumber to = new PhoneNumber(phoneNumber);
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		Message.creator(to, from, message)
				.create();
	}

	private void checkOtpAreMatched(OtpModel otpModel, String otp) {
		if(otpModel.getExpirationTime() >= System.currentTimeMillis()) {
			if(! otp.equals(otpModel.getOtp()))
				throw new InValidOtpException(HttpStatus.BAD_REQUEST, "Entered OTP is incorrect", INVALID_OTP_ENTERED);
			else
				userStorage.findAndUpdate(otpModel.getPhoneNumber(), otp);
		} else {
			throw new InValidOtpException(HttpStatus.FORBIDDEN, "Entered OTP is expired", OTP_EXPIRED);
		}
	}

	private OtpModel generateAndSendOtp(Calendar requestedTime, String phoneNumber) {
		String fourDigitCode = generateFourDigitCode();
		String greeting = greetings(requestedTime);
		String message = greeting + MSG_FORMAT + fourDigitCode;
		System.err.println(message);

		OtpModel otpModel = new OtpModel();
		otpModel.setOtp(fourDigitCode);
		otpModel.setPhoneNumber(phoneNumber);
		otpModel.setExpirationTime(System.currentTimeMillis() + otpExpityTime);
		sendOtpMessage(phoneNumber, message);
		return otpModel;
	}
}
