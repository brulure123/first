package com.test.first.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.first.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
