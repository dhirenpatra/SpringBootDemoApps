package com.springboot.otp.repository;

import com.springboot.otp.request.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {

}
