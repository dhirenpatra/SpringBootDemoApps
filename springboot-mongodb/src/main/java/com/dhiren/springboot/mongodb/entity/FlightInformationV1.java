/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.entity;

import com.dhiren.springboot.mongodb.constants.FlightType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("flights-r/w-converted")
public class FlightInformationV1 extends AbstractFlightInformation {

    private AircraftV1 aircraft;

    public FlightInformationV1(String departureCity, String destinationCity, FlightType flightType,
                               boolean isDelayed, int durationMin, LocalDate departureDate, AircraftV1 aircraft) {
        super(departureCity,destinationCity,flightType,isDelayed,durationMin,departureDate);
        this.aircraft = aircraft;
    }

}
