
package com.springboot.otp.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.springboot.otp.request.VerifyOtpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.SmsRequest;
import com.springboot.otp.service.MessagingService;

@RestController
@RequestMapping("/api")
public class LoginLogoutController {

	private MessagingService messagingService;

	@Autowired
	public LoginLogoutController(MessagingService messagingService) {
		this.messagingService = messagingService;
	}

	@PostMapping("/testsms")
	public ResponseEntity<?> sendMessage(@Valid @RequestBody SmsRequest smsRequest) {
		messagingService.sendMessage(smsRequest);
		return ResponseEntity.status(200)
		        .build();
	}

	@PostMapping("/signup")
	public ResponseEntity<String> sendSignUpOtp(@Valid @RequestBody SignUpRequest signUpRequest,
	                                       HttpServletRequest httpServletRequest) {

		messagingService.sendSignUpOtp(signUpRequest,
		                               Calendar.getInstance(httpServletRequest.getLocale()));

		return ResponseEntity.status(200).body("OTP sent successfully");
	}

	@PostMapping("/verify")
	public ResponseEntity<String> verifyOtp(@Valid @RequestBody VerifyOtpRequest verifyOtpRequest) {
		messagingService.verifyOtp(verifyOtpRequest);
		return ResponseEntity.status(200).body("OTP verification successful");
	}

	@PostMapping("/signin")
	public ResponseEntity<?> sendSignInOtp(@Valid @RequestBody SignInRequest signInRequest,
	                                       HttpServletRequest httpServletRequest) {

		messagingService.sendSignInOtp(signInRequest,
		                               Calendar.getInstance(httpServletRequest.getLocale()));

		return ResponseEntity.status(200)
		        .build();
	}

}
