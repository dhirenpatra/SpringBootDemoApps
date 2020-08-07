package com.springboot.otp.request;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "authordata")
public class Author {

    @Id
    private String id;

    private String authorName;

    private List<Wife> wifeList;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(String authorName,List<Wife> wifeList) {
        this.authorName = authorName;
        this.wifeList = wifeList;
    }
}
