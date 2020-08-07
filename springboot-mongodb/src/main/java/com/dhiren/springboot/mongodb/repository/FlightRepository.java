/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.repository;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FlightRepository extends MongoRepository<FlightInformation,String> {

    List<FlightInformation> findByFlightTypeEquals(FlightType type);

    List<FlightInformation> findByDepartureCity(String departure);

    List<FlightInformation> findByDurationMinBetweenOrderByDurationMinAsc(int minDuration, int maxDuration);

    List<FlightInformation> findByDepartureCityAndIsDelayedTrue(String departure);

    List<FlightInformation> findByDepartureCityOrDestinationCityAndIsDelayedFalse(String departure, String destination);

    @Query(" { 'aircraft.model' : ?0 } ")
    List<FlightInformation> findFlightsByModel(String model);

    List<FlightInformation> findByDestinationCity(String city);

    default List<FlightInformation> updateStatusOfFlightsOf(String destination, boolean status) {
        return saveAll(findByDestinationCity(destination).stream()
                .map(flightInformation -> {
                    flightInformation.setDelayed(status);
                    return flightInformation;
                }).collect(Collectors.toList()));
    }
}
