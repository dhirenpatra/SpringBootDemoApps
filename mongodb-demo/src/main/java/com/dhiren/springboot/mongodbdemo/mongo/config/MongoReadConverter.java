/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.config;

import com.dhiren.springboot.mongodbdemo.mongo.entity.Address;
import org.springframework.core.convert.converter.Converter;

import static com.dhiren.springboot.mongodbdemo.mongo.constants.AppConstants.DELIMITER;

public class MongoReadConverter implements Converter<String, Address> {

    @Override
    public Address convert(String aircraft) {
        String[] strings = aircraft.split(DELIMITER.getType());
        return new Address(strings[0], strings[1]);
    }

}
