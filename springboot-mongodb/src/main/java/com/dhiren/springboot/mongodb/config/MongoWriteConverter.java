/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.config;

import com.dhiren.springboot.mongodb.entity.Aircraft;
import org.springframework.core.convert.converter.Converter;

public class MongoWriteConverter implements Converter<Aircraft,String> {

    private static final String DELIMITER = " : with seat no : ";

    @Override
    public String convert(Aircraft aircraft) {
        return aircraft.getModel() + DELIMITER +aircraft.getNbSeat();
    }

}
