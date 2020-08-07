package org.dhiren.spring.springsecuritydemo.repo;

import org.dhiren.spring.springsecuritydemo.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

}
