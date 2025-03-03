package com.test.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.first.models.Post;
import com.test.first.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return (List<Post>) this.repository.findAll();
    }

    public Post getPostById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Post createPost(Post post) {
        return this.repository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        post.setId(id);
        return this.repository.save(post);
    }

    public void deletePost(Long id) {
        this.repository.deleteById(id);
    }
}
