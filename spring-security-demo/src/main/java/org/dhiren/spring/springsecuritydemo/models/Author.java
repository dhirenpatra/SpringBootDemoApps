package org.dhiren.spring.springsecuritydemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "authordata")
public class Author {

    @Id
    private String id;

    @NotNull
    private String authorName;

    @NotEmpty
    private List<Wife> wifeList;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(String authorName, List<Wife> wifeList) {
        this.authorName = authorName;
        this.wifeList = wifeList;
    }
}
