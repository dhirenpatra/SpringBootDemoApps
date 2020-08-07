/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.adapter;

public class AppleAdapter implements Apple {

    private final Orange orange;

    public AppleAdapter(Orange orange) {
        this.orange = orange;
    }

    @Override
    public String getVeriety() {
        return orange.getVeriety();
    }

    @Override
    public void eat() {
        orange.peel();
        orange.eat();
    }
}
