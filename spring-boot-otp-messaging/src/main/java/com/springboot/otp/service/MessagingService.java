package com.springboot.otp.service;

import com.springboot.otp.request.SignInRequest;
import com.springboot.otp.request.SignUpRequest;
import com.springboot.otp.request.VerifyOtpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.otp.request.SmsRequest;
import com.springboot.otp.sender.SmsSender;

import java.util.Calendar;

@Service
public class MessagingService {

    private SmsSender smsSender;

    @Autowired
    public MessagingService(@Qualifier("twilio") SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendMessage(SmsRequest smsRequest){
        smsSender.sendTestMessage(smsRequest);
    }

    public void sendSignUpOtp(SignUpRequest signUpRequest, Calendar requestedTime){
        smsSender.sendSignUpOtp(signUpRequest, requestedTime);
    }

    public void sendSignInOtp(SignInRequest signInRequest, Calendar requestedTime){
        smsSender.sendSignInOtp(signInRequest, requestedTime);
    }

    public void verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        smsSender.verifyOtp(verifyOtpRequest);
    }

}
