/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("airports")
public class Airport {

    @Id private String id;
    private String name;
    private String city;
    private int passengersServed;

    public Airport(String name, String city, int passengersServed) {
        this.name = name;
        this.city = city;
        this.passengersServed = passengersServed;
    }
}
