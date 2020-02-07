package org.dhiren.spring.springsecuritydemo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wife {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private int age;

    public Wife(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
