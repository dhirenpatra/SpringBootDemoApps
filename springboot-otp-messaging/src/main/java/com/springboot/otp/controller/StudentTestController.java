package com.springboot.otp.controller;

import com.springboot.otp.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentTestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        final List<Student> students = List.of(
                new Student(1, "as"),
                new Student(1, "as"),
                new Student(2, "as"),
                new Student(3, "as"),
                new Student(4, "as"),
                new Student(5, "as")
        );

        final List<Student> students1 = Collections.emptyList();



        return students.stream().distinct().filter(s -> !students1.contains(s)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getInJavaUtilDateFormat());
    }

    private static Date getInJavaUtilDateFormat() {
        return Date.from(ZonedDateTime.parse("2020-07-28T14:28:52.877Z").toInstant());
    }



}
