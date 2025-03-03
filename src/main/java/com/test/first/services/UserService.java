package com.test.first.services;

import java.util.List;

import com.test.first.dto.PasswordChangerDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.first.models.User;
import com.test.first.repositories.UserRepository;

@Service
public class UserService{

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<User> getAll() {
        return (List<User>) this.repository.findAll();
    }
  
    public User getUserById(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return this.repository.findByUsername(username).orElse(null);
    }
    
    public User createUser(User user) {
        user.setPassword(this.encoder.encode(user.getPassword()));
        return this.repository.save(user);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        User currentUser = this.repository.findById(id).orElse(null);
        assert currentUser != null : "User not found";
        user.setPassword(currentUser.getPassword());
        user.setUsername(currentUser.getUsername());
        return this.repository.save(user);
    }

    public User updatePassword(PasswordChangerDTO passwordChangerDTO) {
        User currentUser = this.repository.findById(passwordChangerDTO.getIdUser()).orElse(null);
        assert currentUser != null : "User not found";

        if(this.encoder.matches(passwordChangerDTO.getOldPassword(), currentUser.getPassword())) {
            currentUser.setPassword(this.encoder.encode(passwordChangerDTO.getNewPassword()));
            return this.repository.save(currentUser);
        }

        return null;
    }

    public void deleteUser(long id) {
        this.repository.deleteById(id);        
    }

    public boolean existsByUsername(String username) {
        User user = this.getUserByUsername(username);
        return user != null;
    }

    public boolean existById(Long id) {
        return this.repository.existsById(id);
    }

}
