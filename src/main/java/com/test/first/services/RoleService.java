package com.test.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.first.models.Role;
import com.test.first.repositories.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository repository;

    public List<Role> getAllRoles() {
        return (List<Role>) this.repository.findAll();
    }

    public Role getRoleById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Role createRole(Role role) {
        return this.repository.save(role);
    }

    public Role updateRole(Long id, Role role) {
        role.setId(id);
        return this.repository.save(role);
    }

    public void deleteRole(Long id) {
        this.repository.deleteById(id);
    }
}
