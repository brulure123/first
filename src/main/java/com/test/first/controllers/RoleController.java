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

import com.test.first.models.Role;
import com.test.first.services.RoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @GetMapping
    private List<Role> getAllRoles() {
        return this.roleService.getAllRoles();
    }

    @GetMapping("{id}")
    private Role read(@PathVariable Long id) {
        return this.roleService.getRoleById(id);
    }

    @PostMapping
    private Role create(@RequestBody Role role) {
        return this.roleService.createRole(role);
    }

    @PutMapping("{id}")
    private Role update(@PathVariable Long id, @RequestBody Role role) {
        return this.roleService.updateRole(id, role);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id) {
        this.roleService.deleteRole(id);
    }
}
