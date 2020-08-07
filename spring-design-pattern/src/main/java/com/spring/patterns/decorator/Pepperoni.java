/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.decorator;

import java.math.BigDecimal;

public class Pepperoni extends PizzaIngredient {

    private Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " with pepperoni ..";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(12.99).add(pizza.getCost());
    }
}
