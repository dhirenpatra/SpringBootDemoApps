/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.repository;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightDetails;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FlightDetailsRepository extends MongoRepository<FlightDetails,String> {

}
