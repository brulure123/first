package com.test.first.dto;

import com.test.first.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.stream.Collectors;

public class SecurityUser implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;
    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    // Implémentation des méthodes de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getRoles().stream()
                .flatMap(role -> role.getAuthorities().stream()) // Aplatir la liste des autorités
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }
}
