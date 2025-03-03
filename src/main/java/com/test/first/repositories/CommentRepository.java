package com.test.first.repositories;

import org.springframework.data.repository.CrudRepository;

import com.test.first.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
