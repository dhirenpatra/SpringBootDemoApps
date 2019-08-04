package com.springboot.otp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {

    @NotNull
    private String message;

    private Instant currentTime;

    @NotNull
    private String receiverPhone;

}
