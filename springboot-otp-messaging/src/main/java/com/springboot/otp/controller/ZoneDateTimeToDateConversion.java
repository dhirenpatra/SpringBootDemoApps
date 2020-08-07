package com.springboot.otp.controller;

import java.time.ZonedDateTime;
import java.util.Date;

public class ZoneDateTimeToDateConversion {

    public static void main(String[] args) {
        System.out.println(getInJavaUtilDateFormat());
    }

    private static Date getInJavaUtilDateFormat() {
        return Date.from(ZonedDateTime.parse("2020-07-28T14:28:52.877Z").toInstant());
    }

}
