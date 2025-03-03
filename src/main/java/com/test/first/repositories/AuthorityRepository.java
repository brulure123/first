package com.test.first.repositories;

import org.springframework.data.repository.CrudRepository;

import com.test.first.models.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long>{
    
}
