package com.springboot.otp.controller;

import com.springboot.otp.repository.CourseRepository;
import com.springboot.otp.request.Course;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/courses")
    public Course addCourse(@Valid @RequestBody final Course course) {
        return repository.save(course);
    }
}
