package com.springboot.otp.sender;

import java.util.Calendar;
import java.util.Random;

import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.SmsRequest;
import com.springboot.otp.request.VerifyOtpRequest;

public interface SmsSender {

    final String MSG_FORMAT = "! Your Verification code is ";

    void sendTestMessage(SmsRequest smsRequest);
    void sendSignUpOtp(SignUpRequest signUpRequest, Calendar requestedTime);
    void sendSignInOtp(SignInRequest signInRequest, Calendar requestedTime);
    void verifyOtp(VerifyOtpRequest otpRequest);
    void sendOtpMessage(String phoneNumber, String message);
    default String generateFourDigitCode() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    default String greetings(Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return hour <= 16 && minute > 0 ? "Good Morning" : "Hello";
    }
}
