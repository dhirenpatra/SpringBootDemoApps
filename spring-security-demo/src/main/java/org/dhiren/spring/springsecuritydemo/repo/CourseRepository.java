package org.dhiren.spring.springsecuritydemo.repo;

import org.dhiren.spring.springsecuritydemo.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {

}
