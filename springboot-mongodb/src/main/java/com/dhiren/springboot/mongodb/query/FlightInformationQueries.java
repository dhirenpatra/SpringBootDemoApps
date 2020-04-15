package com.dhiren.springboot.mongodb.query;

import com.dhiren.springboot.mongodb.constants.FlightType;
import com.dhiren.springboot.mongodb.entity.FlightInformation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInformationQueries {

    private MongoTemplate mongoTemplate;

    public FlightInformationQueries(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * TODO : Implement following queries
     *
     *
     *  Find all flights by departure city
     *  Find all flights between duration min and max
     *  Find all flights delayed at a particular departure city
     *  Find all flights on time at a particular city
     *  Find by aircraft model
     */

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
}
