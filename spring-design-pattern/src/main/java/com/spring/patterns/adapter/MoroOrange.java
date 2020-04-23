/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.adapter;

public class MoroOrange implements Orange {
    @Override
    public String getVeriety() {
        return "Moro Blood Orange";
    }

    @Override
    public void eat() {
        System.out.println("Enjoy eating..");
    }

    @Override
    public void peel() {
        System.out.println("Start peeling..");
    }

    @Override
    public void juice() {
        System.out.println("Try Juice");
    }
}
