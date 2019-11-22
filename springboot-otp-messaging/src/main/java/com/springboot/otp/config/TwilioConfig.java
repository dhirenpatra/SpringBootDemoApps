package com.springboot.otp.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(TwilioConfig.class);

    private String accountSid;
    private String authToken;
    private String trialNumber;

    @Override
    public String toString() {
        return "TwilioConfig{" +
                "accountSid='" + accountSid + '\'' +
                ", authToken='" + authToken + '\'' +
                ", trialNumber='" + trialNumber + '\'' +
                '}';
    }
}
