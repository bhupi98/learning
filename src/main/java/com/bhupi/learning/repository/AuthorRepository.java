package com.bhupi.learning.repository;

import com.bhupi.learning.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findById(int id);
    Author findByEmail(String email);
    Author findByEmailAndName(String email,String name);
}
