/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.config;

import com.dhiren.springboot.mongodbdemo.mongo.entity.Address;
import org.springframework.core.convert.converter.Converter;

public class MongoReadConverter implements Converter<String, Address> {

    private static final String DELIMITER = " of ";

    @Override
    public Address convert(String aircraft) {
        String[] strings = aircraft.split(DELIMITER);
        return new Address(strings[0], strings[1]);
    }

}
