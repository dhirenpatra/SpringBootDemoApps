/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.singleton;

import com.spring.patterns.singleton.SingletonClass;
import com.spring.patterns.singleton.SingletonClass2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonDesignPattern {

    @Autowired
    private SingletonClass2 instance1;

    @Autowired
    private SingletonClass2 instance2;

    @Test
    public void contextLoads() {
        SingletonClass i1 = SingletonClass.getInstance();
        SingletonClass i2 = SingletonClass.getInstance();

        Assert.assertNotNull(instance1);
        Assert.assertNotNull(instance2);
        Assert.assertNotNull(i1);
        Assert.assertNotNull(i2);

        Assert.assertSame(instance1,instance2);
        Assert.assertSame(i1,i2);
    }

}

