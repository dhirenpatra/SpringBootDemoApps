package org.dhiren.spring.springsecuritydemo.service;

import org.dhiren.spring.springsecuritydemo.models.Author;
import org.dhiren.spring.springsecuritydemo.repo.AuthorRepository;
import org.dhiren.spring.springsecuritydemo.source.AuthorRegistrationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@EnableBinding(AuthorRegistrationSource.class)
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorRegistrationSource source;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorRegistrationSource source) {
        this.authorRepository = authorRepository;
        this.source = source;
    }

    public Author saveAndPublish(Author author ){
        source.authorRegistration().send(MessageBuilder.withPayload(author).build());

        source.authorRegistration().send(
                MessageBuilder.createMessage(author, new MessageHeaders(Collections.singletonMap("test-name","Dhiren")))
        );

        return authorRepository.save(author);
    }

    public Author getAAuthor(String authorId ){
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        return optionalAuthor.orElse(null);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
