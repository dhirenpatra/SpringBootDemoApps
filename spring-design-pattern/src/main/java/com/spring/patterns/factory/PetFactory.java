/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    public Pet getPet(String petType) {
        switch (petType.toLowerCase()) {
            case "dog" :
                return new Dog();
            case "cat" :
                return new Cat();
            default:
                throw new UnsupportedOperationException("Type not Supported");
        }
    }

}
