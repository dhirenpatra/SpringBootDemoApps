package com.springboot.otp.controller;

import com.springboot.otp.repository.CourseRepository;
import com.springboot.otp.request.Course;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    private CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @PostMapping("/courses/course")
    public Course addCourse(@Valid @RequestBody final Course course) {
        return repository.save(course);
    }

    @DeleteMapping("/courses")
    public void deleteAllCourses() {
        repository.deleteAll();
    }
}
