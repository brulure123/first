package com.test.first.controllers;

import java.util.List;

import com.test.first.dto.PasswordChangerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.first.models.User;
import com.test.first.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        if (userService.existsByUsername(user.getUsername()))
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        User u = userService.createUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = this.userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        if(userService.existById(id))
            return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
        else return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody User user) {
        if(userService.existById(id)) {
            User u = this.userService.updateUser(id, user);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } else return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<?> updatePassword(@RequestBody PasswordChangerDTO password) {
        if(userService.existById(password.getIdUser())) {
            User user = this.userService.updatePassword(password);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        if(userService.existById(id)) {
            this.userService.deleteUser(id);
            return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
        } else return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
    }
}
