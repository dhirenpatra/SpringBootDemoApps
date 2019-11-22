
package com.springboot.otp.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.springboot.otp.request.Wife;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.springboot.otp.repository.AuthorRepository;
import com.springboot.otp.repository.CourseRepository;
import com.springboot.otp.request.Author;
import com.springboot.otp.request.Course;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationRunner implements CommandLineRunner {

    private String[] authors = new String[] {"Dhiren", "Anushka", "Brad", "Andrew", "Stephane", "Ranga"};
    private String[] categories
            = new String[] {"JS", "Java", "Spring Boot", "React", "Microservices", "Docker"};
    private String[] courses
            = new String[] {"Javascript Mastery", "Java master", "Spring Boot Zero to Hero",
            "React fullstack", "Microservices Architecture", "Docker tits by bits"};

	private CourseRepository courseRepository;
	private AuthorRepository authorRepository;

	@Autowired
	public MyApplicationRunner(CourseRepository courseRepository,
	                           AuthorRepository authorRepository) {
		this.courseRepository = courseRepository;
		this.authorRepository = authorRepository;
	}

	private void addAuthors() {
		for(int i = 0 ; i< 6; i++) {
			authorRepository.save(new Author(authors[i],Arrays.asList(new Wife("1","AX",23),
					new Wife("1","AY",23))));
		}
	}

	private void addCourses() {
		final String[] collect = authorRepository.findAll().stream()
				.map(author -> author.getId()).collect(Collectors.toList())
				.toArray(new String[0]);
		for(int i = 0 ; i< 100; i++) {
			courseRepository.save(new Course(randomCourses(new Random().nextInt(courses.length)), "Slug",
					collect[new Random().nextInt(collect.length)],
					randomCategory(new Random().nextInt(courses.length))));
		}
	}

	@Override
    public void run(String... args) throws Exception {
		addAuthors();
		addCourses();
	}

	private String randomCategory(int position) {
		return categories[position];
	}

	private String randomCourses(int position) {
		return courses[position];
	}

}
