/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.config;

import com.dhiren.springboot.mongodbdemo.mongo.constants.AppConstants;
import com.dhiren.springboot.mongodbdemo.mongo.entity.Address;
import org.springframework.core.convert.converter.Converter;

import static com.dhiren.springboot.mongodbdemo.mongo.constants.AppConstants.*;

public class MongoWriteConverter implements Converter<Address, String> {

    @Override
    public String convert(Address aircraft) {
        return aircraft.getCity() + DELIMITER.getType() +aircraft.getCountry();
    }

}
