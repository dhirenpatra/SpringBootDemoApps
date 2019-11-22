package com.springboot.otp.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.springframework.util.StringUtils.uncapitalize;

@Component
public class ServiceController {

    @Autowired
    protected Map<String, Service> serviceMap;

    public <C extends Service> C executor(Class<C> serviceClass, String id) {
        System.err.println(serviceMap);
        if("PRO".equalsIgnoreCase(id)){
            StringBuilder sb = new StringBuilder(uncapitalize(AppleServiceMacBookPro.class.getSimpleName()));
            return serviceClass.cast(serviceMap.get(sb.toString()));
        }  else if("AIR".equalsIgnoreCase(id)) {
            StringBuilder sb = new StringBuilder(uncapitalize(AppleServiceMacBookAir.class.getSimpleName()));
            return serviceClass.cast(serviceMap.get(sb.toString()));
        } else {
            return null;
        }
    }

}
