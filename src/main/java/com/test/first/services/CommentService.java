package com.test.first.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.first.models.Comment;
import com.test.first.repositories.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository repository;

    public List<Comment> getAllComments() {
        return (List<Comment>) this. repository.findAll();
    }

    public Comment getCommentById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Comment createComment(Comment comment) {
        comment.setCommentDateTime(LocalDateTime.now());
        return this.repository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        comment.setId(id);
        comment.setCommentDateTime(LocalDateTime.now());
        return this.repository.save(comment);
    }

    public void deleteComment(Long id) {
        this.repository.deleteById(id);
    }
}
