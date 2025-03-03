package com.test.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.first.models.Authority;
import com.test.first.repositories.AuthorityRepository;

@Service
public class AuthorityService {
    
    @Autowired
    private AuthorityRepository repository;

    public List<Authority> getAllAuthority() {
        return (List<Authority>) this.repository.findAll();
    }

    public Authority getAuthorityById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Authority createAuthority(Authority authority) {
        return this.repository.save(authority);
    }

    public Authority updateAuthority(Long id, Authority authority) {
        authority.setId(id);
        return this.repository.save(authority);
    }

    public void deleteAuthority(Long id) {
        this.repository.deleteById(id);
    }
}
