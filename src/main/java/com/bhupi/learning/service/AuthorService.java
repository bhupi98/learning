package com.bhupi.learning.service;

import com.bhupi.learning.model.Author;

import java.util.List;

public interface AuthorService {


    public Author createAuthor(Author author);

    public List <Author>getAuthors();

    public Author getAuthorByEmail(String email);
    Author getAuthorById(int id);
    public Author getAuthorByNameAndEmail(String email,String name);
}
