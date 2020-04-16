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
@Document("flights")
public class FlightInformation {

    @Id
    private String id;

    @Indexed(unique = true)
    private String internalId = UUID.randomUUID().toString();

    @Field("departure")
    @Indexed
    private String departureCity;

    @Field("destination")
    @Indexed
    private String destinationCity;

    private FlightType flightType;

    private boolean isDelayed;

    private int durationMin;

    private LocalDate departureDate;

    private Aircraft aircraft;

    @Transient
    private LocalDate createdAt = LocalDate.now();

    public FlightInformation(String departureCity, String destinationCity, FlightType flightType,
                             boolean isDelayed, int durationMin, LocalDate departureDate, Aircraft aircraft) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.flightType = flightType;
        this.isDelayed = isDelayed;
        this.durationMin = durationMin;
        this.departureDate = departureDate;
        this.aircraft = aircraft;
    }

}
