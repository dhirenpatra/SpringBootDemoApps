package com.springboot.otp.config;

import com.springboot.otp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    private AuthorRepository repository;

    @Autowired
    public ScheduledTask(AuthorRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 1000)
    public void runAfterCertainDelay() {
        System.out.println("Running Every Second ..");
/*        System.out.println("Starting and Fetching..."+ LocalDateTime.now());
        repository.findAll().forEach(System.out::println);
        System.out.println("Ended...by.."+Thread.currentThread().getName() + " : " + LocalDateTime.now());
        repository.save(new Author(UUID.randomUUID().toString(),
                List.of(new Wife(UUID.randomUUID().toString(), new Random().nextInt()))));*/
    }

}
