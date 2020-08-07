/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.adapter;

import org.junit.Test;

public class AdapterDesignPattern {

    @Test
    public void contextLoads() {
        Orange orange = new MoroOrange();
        AppleAdapter apple = new AppleAdapter(orange);
        System.out.println(apple.getVeriety());
        apple.eat();
    }

}
