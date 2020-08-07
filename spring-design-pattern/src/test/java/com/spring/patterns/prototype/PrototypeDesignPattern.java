/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.prototype;

import com.spring.patterns.singleton.SingletonClass2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeDesignPattern {

    @Autowired
    private ProtoTrue instance1;
    @Autowired
    private ProtoTrue instance2;

    @Autowired
    private ProtoFalse instance3;
    @Autowired
    private ProtoFalse instance4;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(instance1);
        Assert.assertNotNull(instance2);
        Assert.assertNotNull(instance3);
        Assert.assertNotNull(instance4);

        Assert.assertNotSame(instance1,instance2);
        Assert.assertSame(instance3,instance4);

    }

}

