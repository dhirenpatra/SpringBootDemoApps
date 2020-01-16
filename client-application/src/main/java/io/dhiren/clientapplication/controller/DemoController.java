package io.dhiren.clientapplication.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DemoController {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/getNextServerFromEureka")
    public String callService() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        final InstanceInfo service = eurekaClient.getNextServerFromEureka("service", false);
        System.err.println(service);
        final String baseURL = service.getHomePageUrl();
        final ResponseEntity<String> exchange = restTemplate.exchange(baseURL, HttpMethod.GET, null, String.class);
        return exchange.getBody();
    }

    @GetMapping("/getInstanceOne")
    public String callService1() {
        return callInstance(0);
    }

    @GetMapping("/getInstanceTwo")
    public String callService2() {
        return callInstance(1);
    }

    private String callInstance(int i) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        final List<ServiceInstance> service = discoveryClient.getInstances("service");
        final String baseURL = service.get(i).getUri().toString();
        System.err.println(baseURL);
        final ResponseEntity<String> exchange = restTemplate.exchange(baseURL, HttpMethod.GET, null, String.class);
        return exchange.getBody();
    }

}
