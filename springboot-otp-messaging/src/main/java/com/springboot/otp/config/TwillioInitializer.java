package com.springboot.otp.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwillioInitializer {

    private static Logger LOGGER = LoggerFactory.getLogger(TwillioInitializer.class);

    private TwilioConfig twilioConfig;

    @Autowired
    public TwillioInitializer(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(
                twilioConfig.getAccountSid(),
                twilioConfig.getAuthToken()
        );

        LOGGER.info("Twilio Initialized ... with {}",twilioConfig.getAccountSid());
    }
    
}
