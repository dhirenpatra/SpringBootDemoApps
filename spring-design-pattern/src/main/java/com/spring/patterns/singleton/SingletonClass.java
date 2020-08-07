/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.singleton;

public class SingletonClass {

    private static SingletonClass instance;

    public static SingletonClass getInstance() {
        if(null == instance) {
            synchronized (SingletonClass.class) {
                if(null == instance)
                    instance = new SingletonClass();
            }
        }
        return instance;
    }

}
