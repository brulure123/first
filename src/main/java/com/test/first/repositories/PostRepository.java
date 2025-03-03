package com.test.first.repositories;

import org.springframework.data.repository.CrudRepository;

import com.test.first.models.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
