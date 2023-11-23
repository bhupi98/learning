package com.bhupi.learning.service;

import com.bhupi.learning.model.Author;
import com.bhupi.learning.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }



    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author getAuthorByNameAndEmail(String email, String name) {
        return authorRepository.findByEmailAndName(email, name);
    }
}
