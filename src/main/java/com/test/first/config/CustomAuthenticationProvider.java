package com.test.first.config;

import com.test.first.dto.SecurityUser;
import com.test.first.services.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsServiceImpl service;
    private final PasswordEncoder encoder;

    public CustomAuthenticationProvider(UserDetailsServiceImpl service) {
        this.service = service;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        SecurityUser securityUser = (SecurityUser) this.service.loadUserByUsername(username);

        if(securityUser == null)
            throw new UsernameNotFoundException("Unknown user : " + username);

        if(this.encoder.matches(password, securityUser.getPassword()))
            return new UsernamePasswordAuthenticationToken(
                    securityUser.getUsername(),
                    securityUser.getPassword(),
                    securityUser.getAuthorities());
        else throw new AuthenticationCredentialsNotFoundException("Error !");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
