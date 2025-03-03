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

import com.test.first.models.Authority;
import com.test.first.services.AuthorityService;

@RestController
@RequestMapping("api/authorities")
public class AuthorityController {
    
    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public List<Authority> getAllAuthorities () {
        return this.authorityService.getAllAuthority();
    }

    @GetMapping("{id}")
    public Authority read(@PathVariable Long id) {
        return this.authorityService.getAuthorityById(id);
    }

    @PostMapping
    public Authority create(@RequestBody Authority authority) {
        return this.authorityService.createAuthority(authority);
    }

    @PutMapping("{id}")
    public Authority update(@PathVariable Long id, @RequestBody Authority authority) {
        return this.authorityService.updateAuthority(id, authority);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.authorityService.deleteAuthority(id);
    }
}
