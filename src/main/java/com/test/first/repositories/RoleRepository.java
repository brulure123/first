package com.test.first.repositories;

import org.springframework.data.repository.CrudRepository;

import com.test.first.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
    
}
