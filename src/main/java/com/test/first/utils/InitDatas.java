/**package com.test.first.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.test.first.models.Authority;
import com.test.first.models.Role;
import com.test.first.repositories.AuthorityRepository;
import com.test.first.repositories.RoleRepository;

@Component
public class InitDatas implements CommandLineRunner{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName("ADMIN");
        

        Authority authority = new Authority();
        authority.setName("Read");
        List<Role> list = new ArrayList<>();
        list.add(role);
        authority.setRoles(list);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        role.setAuthorities(authorities);
        
        authorityRepository.save(authority);
        this.roleRepository.save(role);

    }
    
}*/
