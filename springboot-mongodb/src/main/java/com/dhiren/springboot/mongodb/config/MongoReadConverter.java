/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.config;

import com.dhiren.springboot.mongodb.entity.AircraftV1;
import org.springframework.core.convert.converter.Converter;

public class MongoReadConverter implements Converter<String, AircraftV1> {

    private static final String DELIMITER = " : with seat no : ";

    @Override
    public AircraftV1 convert(String aircraft) {
        String[] strings = aircraft.split(DELIMITER);
        return new AircraftV1(strings[0],Integer.valueOf(strings[1]));
    }

}
