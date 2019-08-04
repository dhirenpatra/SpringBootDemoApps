package com.springboot.otp.sender;

import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.SmsRequest;

import java.util.Calendar;

public interface SmsSender {

    void sendTestMessage(SmsRequest smsRequest);
    void sendSignUpOtp(SignUpRequest signUpRequest, Calendar requestedTime);
    void sendSignInOtp(SignInRequest signInRequest, Calendar requestedTime);
}
