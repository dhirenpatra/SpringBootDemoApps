/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.repository;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformationV1;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FlightRepositoryV1 extends MongoRepository<FlightInformationV1,String> {

    List<FlightInformationV1> findByFlightTypeEquals(FlightType type);

    List<FlightInformationV1> findByDepartureCity(String departure);

    List<FlightInformationV1> findByDurationMinBetweenOrderByDurationMinAsc(int minDuration, int maxDuration);

    List<FlightInformationV1> findByDepartureCityAndIsDelayedTrue(String departure);

    List<FlightInformationV1> findByDepartureCityOrDestinationCityAndIsDelayedFalse(String departure, String destination);

    @Query(" { 'aircraft.model' : ?0 } ")
    List<FlightInformationV1> findFlightsByModel(String model);

    List<FlightInformationV1> findByDestinationCity(String city);

    default List<FlightInformationV1> updateStatusOfFlightsOf(String destination, boolean status) {
        return saveAll(findByDestinationCity(destination).stream()
                .map(FlightInformationV1 -> {
                    FlightInformationV1.setDelayed(status);
                    return FlightInformationV1;
                }).collect(Collectors.toList()));
    }
}
