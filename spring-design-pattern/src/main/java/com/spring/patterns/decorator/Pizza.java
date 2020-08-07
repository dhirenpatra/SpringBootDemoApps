/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.decorator;

import java.math.BigDecimal;

public abstract class Pizza {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getCost();
}
