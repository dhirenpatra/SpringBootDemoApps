/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.config;

import com.dhiren.springboot.mongodbdemo.mongo.entity.Address;
import org.springframework.core.convert.converter.Converter;

public class MongoWriteConverter implements Converter<Address, String> {

    private static final String DELIMITER = " of ";

    @Override
    public String convert(Address aircraft) {
        return aircraft.getCity() + DELIMITER +aircraft.getCountry();
    }

}
