package com.springboot.otp.test.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceControllerImpl extends ServiceController {

    @GetMapping("/apple/{id}")
    public String getAppleName(@PathVariable String id) {
        return executor(AppleService.class, id).getLaptopName();
    }



//    @GetMapping("/laptop/{id}")
//    public String getLaptopName(@PathVariable String id) {
//        return executorById(AppleService.class, id).getLaptopName();
    // }

}
