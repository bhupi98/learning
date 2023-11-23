package com.bhupi.learning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email",unique = true)
    private String email;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    List<Post>posts=new ArrayList<>();
}
