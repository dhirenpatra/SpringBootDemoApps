package org.dhiren.spring.springsecuritydemo.controller;

import org.dhiren.spring.springsecuritydemo.repo.AuthorRepository;
import org.dhiren.spring.springsecuritydemo.models.Author;
import org.dhiren.spring.springsecuritydemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/admin/authors/author")
    public ResponseEntity<Author> createAnAuthor(@RequestBody @Valid Author author){
        return ResponseEntity.ok(authorService.saveAndPublish(author));
    }

    @GetMapping("/admin")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable String id) {
        return authorService.getAAuthor(id);
    }
}
