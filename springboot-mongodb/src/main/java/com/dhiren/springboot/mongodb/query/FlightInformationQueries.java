/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.dhiren.springboot.mongodb.query;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInformationQueries {

    private MongoTemplate mongoTemplate;

    public FlightInformationQueries(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Find All flights with paging and sorting
     *
     * @param field
     * @param pageNo
     * @param pageSize
     *
     * @return
     */
    public List<FlightInformation> getAllFlightsSortedByDistance(String field, int pageNo, int pageSize,
                                                                 Sort.Direction direction) {
        System.err.println("Fetching All Documents and Sorting by "+ direction.toString()+ " for " +field+ " " +
                "and sending pageNo " +pageNo+
                " with "+pageSize+ " documents ...");

        Query getAllFlightsWithSortingAndPaging = new Query()
                .with(Sort.by(direction,field))
                .with(PageRequest.of(pageNo,pageSize));
        return this.mongoTemplate.find(getAllFlightsWithSortingAndPaging, FlightInformation.class);
    }

    /**
     * Find By flightId
     *
     * @param id
     * @return
     */
    public FlightInformation getFlightById(String id) {
        System.err.println("Requested Document id is "+id);
        return mongoTemplate.findById(id, FlightInformation.class);
    }

    /**
     * Count all International || Domestic flights
     *
     * @param type
     * @return
     */
    public long getFlightCategoryCount(FlightType type) {

        System.err.println("Requested Flight type is "+type);

        return mongoTemplate.count(
                new Query(Criteria.where("flightType").is(type.toString())),
                FlightInformation.class);
    }

    /**
     * Find all flights by departure city
     *
     * @param departure
     * @return
     */
    public List<FlightInformation> findByDepartureCity(String departure) {
        System.err.println("Requested Departure city is "+departure);
        return mongoTemplate.find(Query.query(Criteria.where("departure").is(departure)),FlightInformation.class);
    }

    /**
     * Find all flights between duration min and max
     *
     * @param minDuration
     * @param maxDuration
     * @return
     */
    public List<FlightInformation> findByDurationBetween(int minDuration, int maxDuration) {
        System.err.println("All flight between "+minDuration+ " and "+maxDuration+" duration..");
         return mongoTemplate.find(Query.query(Criteria.where("durationMin").gte(minDuration).lte(maxDuration))
                .with(Sort.by(Sort.Direction.ASC,"durationMin")),FlightInformation.class);
    }

    /**
     * Find all flights delayed at a particular departure city
     *
     * @param city
     * @return
     */
    public List<FlightInformation> findFlightsDelayedAtACity(String city) {
        System.err.println("Requested Departure city is "+city+ " with delayed flights.");
        return mongoTemplate.find(Query.query(Criteria.where("departure").is(city)
                .and("isDelayed").is(true)),FlightInformation.class);
    }

    /**
     * Find all flights on time at a particular city
     *
     * @param city
     * @return
     */
    public List<FlightInformation> findFlightsOnTimeAndRelatedToCity(String city) {

        System.err.println("Requested city is "+city+ " with on time flights to and fro .");

        Query query = Query.query(new Criteria().orOperator(
                Criteria.where("departure").is(city),
                Criteria.where("destination").is(city)
        ).andOperator(Criteria.where("isDelayed").is(false)));

        return mongoTemplate.find(query,FlightInformation.class);
    }

    /**
     * Find by aircraft model
     *
     * @param model
     * @return
     */
    public List<FlightInformation> findFlightsByModel(String model) {
        System.err.println("Requested flight model is "+model);
       return mongoTemplate.find(Query.query(Criteria.where("aircraft.model").is(model)),FlightInformation.class);
    }

    /**
     * Update status of all flights for a particular destination
     *
     * @param destination
     * @param status
     */
    public List<FlightInformation> updateStatusOfFlightsTo(String destination, boolean status) {
        Query query = Query.query(Criteria.where("destination").is(destination));
        Update update = Update.update("isDelayed",status);
        mongoTemplate.updateMulti(query, update, FlightInformation.class).getUpsertedId();
        return mongoTemplate.find(Query.query(Criteria.where("destination").is(destination)),FlightInformation.class);
    }

}
