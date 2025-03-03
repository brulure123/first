package com.test.first.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.first.models.Comment;
import com.test.first.services.CommentService;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAll() {
        return this.commentService.getAllComments();
    }
    
    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return this.commentService.createComment(comment);
    }

    @GetMapping("{id}")
    public Comment read(@PathVariable Long id) {
        return this.commentService.getCommentById(id);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) {
        return this.commentService.updateComment(id, comment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.commentService.deleteComment(id);
    }
    
}
