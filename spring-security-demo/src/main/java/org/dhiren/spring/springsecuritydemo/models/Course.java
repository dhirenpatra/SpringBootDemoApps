package org.dhiren.spring.springsecuritydemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "coursedata")
public class Course {

    @Id
    private String id;
    private String title;
    private String slug;
    private String authorId;
    private String category;

    public Course(String title, String slug, String authorId, String category) {
        this.title = title;
        this.slug = slug;
        this.authorId = authorId;
        this.category = category;
    }
}
