package com.test.first.services;

import com.test.first.dto.SecurityUser;
import com.test.first.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String UNKNOWN_USER_MESSAGE = "Unknown user : ";

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user != null)
            return new SecurityUser(user);
        else throw new UsernameNotFoundException(UNKNOWN_USER_MESSAGE + username);
    }
}
