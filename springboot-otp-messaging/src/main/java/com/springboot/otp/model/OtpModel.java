package com.springboot.otp.model;

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

    @Override
    public String toString() {
        return "OtpModel{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", otp='" + otp + '\'' +
                ", expirationTime=" + expirationTime +
                ", email='" + email + '\'' +
                '}';
    }
}
