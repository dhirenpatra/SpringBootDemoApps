/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodbdemo.mongo.events;

import com.dhiren.springboot.mongodbdemo.mongo.entity.AppEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.*;

import java.time.LocalDateTime;

@Configuration
public class GenericMongoAuditingEvent extends AbstractMongoEventListener<AppEntity> {

    @Override
    public void onAfterSave(AfterSaveEvent<AppEntity> event) {
        final AppEntity source = event.getSource();
        System.err.println("Saving / Updating "+source+" @ : "+ LocalDateTime.now());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<AppEntity> event) {
        final Object source = event.getSource();
        System.err.println("Deleting "+source+" @ : "+ LocalDateTime.now());
    }

    @Override
    public void onAfterLoad(AfterLoadEvent<AppEntity> event) {
        System.err.println("Fetching Documents ... "+event.getSource()+" @ : "+ LocalDateTime.now());
    }
}
