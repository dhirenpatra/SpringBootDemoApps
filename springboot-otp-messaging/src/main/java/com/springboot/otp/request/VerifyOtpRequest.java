package com.springboot.otp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyOtpRequest {

    @NotNull
    private String otp;

    @NotNull
    private String email;

}
