package com.bhupi.learning.service;

import com.bhupi.learning.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post createPost(Post post);
}
