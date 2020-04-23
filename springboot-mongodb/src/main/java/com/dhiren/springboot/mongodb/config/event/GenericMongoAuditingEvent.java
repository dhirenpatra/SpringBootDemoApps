/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.config.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import java.time.LocalDateTime;

@Configuration
public class GenericMongoAuditingEvent extends AbstractMongoEventListener<Object> {

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        final Object source = event.getSource();
        System.err.println("Saving / Updating "+source+" @ : "+ LocalDateTime.now());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        final Object source = event.getSource();
        System.err.println("Deleting "+source+" @ : "+ LocalDateTime.now());
    }

    @Override
    public void onAfterLoad(AfterLoadEvent<Object> event) {
        System.err.println("Fetching Documents ... "+event.getSource()+" @ : "+ LocalDateTime.now());
    }
}
