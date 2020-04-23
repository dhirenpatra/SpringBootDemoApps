/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.config;

import com.dhiren.springboot.mongodb.entity.AircraftV1;
import org.springframework.core.convert.converter.Converter;

public class MongoWriteConverter implements Converter<AircraftV1,String> {

    private static final String DELIMITER = " : with seat no : ";

    @Override
    public String convert(AircraftV1 aircraft) {
        return aircraft.getModel() + DELIMITER +aircraft.getNbSeat();
    }

}
