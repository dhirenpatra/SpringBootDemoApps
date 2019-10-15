package com.springboot.otp.test.service;

import org.springframework.stereotype.Service;

@Service
public abstract class AppleService extends LaptopService {

    public String getLaptopName () {
        return "MacBook";
    }

}
