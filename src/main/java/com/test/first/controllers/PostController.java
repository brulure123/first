package com.test.first.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.first.models.Post;
import com.test.first.services.PostService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll() {
        return this.postService.getAllPosts();
    }
    
    @GetMapping("{id}")
    public Post read(@PathVariable Long id) {
        return this.postService.getPostById(id);
    }
    
    @PostMapping
    public Post create(@RequestBody Post post) {
        System.out.print(post);
        
        return this.postService.createPost(post);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        return this.postService.updatePost(id, post);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.postService.deletePost(id);
    }

}
