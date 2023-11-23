package com.bhupi.learning.controller;

import com.bhupi.learning.model.Author;
import com.bhupi.learning.model.Post;
import com.bhupi.learning.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/name")
    ResponseEntity<Author>GetAuthorByEmailAndName(@RequestParam("email") String email,@RequestParam("name")String name){
        try{
            Author author=authorService.getAuthorByNameAndEmail(email,name);
            return ResponseEntity.ok(author);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   @GetMapping("/")
    ResponseEntity<Author>GetAuthorByEmail(@RequestParam("email") String email){
        try{
          Author author=authorService.getAuthorByEmail(email);
         return ResponseEntity.ok(author);
        }catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
   @GetMapping("/list")
    ResponseEntity <List<Author>> getAuthors(){
        try{
            List<Author> authors=authorService.getAuthors();
            return ResponseEntity.ok(authors);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
 @PostMapping("/create")
    ResponseEntity <Void> saveAuthor(@RequestBody Author author){
        try{
            Author au=new Author();
            au.setEmail(author.getEmail());
            au.setName(author.getName());
            List <Post>posts=author.getPosts();
            if(posts!=null){
                for (Post post : posts) {
                    post.setAuthor(au); // Set the Author reference for each Post
                }
            }
            au.setPosts(posts);
            Author author1=authorService.createAuthor(au);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
