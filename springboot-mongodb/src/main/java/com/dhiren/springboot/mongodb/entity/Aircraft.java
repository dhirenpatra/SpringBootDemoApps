/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Aircraft {

    private String model;

    private int nbSeat;

}
