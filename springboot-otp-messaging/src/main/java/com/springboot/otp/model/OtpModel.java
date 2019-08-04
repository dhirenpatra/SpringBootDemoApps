package com.springboot.otp.model;

import com.springboot.otp.utils.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpModel {

    private String phoneNumber;
    private String otp;
    private long expirationTime;
    private String email;
    private UserType userType;

    @Override
    public String toString() {
        return "OtpModel{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", otp='" + otp + '\'' +
                ", expirationTime=" + expirationTime +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }

    public OtpModel(OtpModel otpModel) {
        this.email = otpModel.getEmail();
        this.phoneNumber = otpModel.getPhoneNumber();
        this.otp = "";
        this.expirationTime = 0l;
        this.userType = UserType.REGISTERED;
    }
}
