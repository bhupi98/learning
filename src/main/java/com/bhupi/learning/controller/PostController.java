package com.bhupi.learning.controller;

import com.bhupi.learning.model.Author;
import com.bhupi.learning.model.Post;
import com.bhupi.learning.service.AuthorService;
import com.bhupi.learning.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
     PostService postService;
     AuthorService authorService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/list")
    ResponseEntity <List<Post>> getPosts(){
        try {
            List<Post> postList= null;
            postList = postService.getAllPosts();
            return ResponseEntity.ok(postList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   @PostMapping("/create")
    ResponseEntity<Void>savePost(@RequestBody Post post){
       System.out.println("Received Post: " + post);

       Author author=post.getAuthor();
       if (author == null) {
           // Handle the case where the Author is null (for example, return a bad request response)
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       Author existingAuthor = authorService.getAuthorById(author.getId());
       System.out.println("Retrieved Author: " + existingAuthor);
        Post post1=postService.createPost(post);
        System.out.println(post1);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
