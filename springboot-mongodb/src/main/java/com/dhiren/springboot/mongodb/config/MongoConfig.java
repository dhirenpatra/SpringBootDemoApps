/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

//@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {

        return new MongoCustomConversions(
                Arrays.asList(new MongoReadConverter(), new MongoWriteConverter())
        );

    }
}
