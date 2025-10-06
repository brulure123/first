package com.test.first.utils;

import java.util.Calendar;
import java.util.Date;

import com.test.first.models.Category;
import com.test.first.models.User;
import com.test.first.repositories.CategoryRepository;
import com.test.first.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryRepository;

    public InitData(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
/**
        User user = new User();
        user.setUsername("thuggerfly");
        user.setPassword(this.passwordEncoder.encode("7252@"));
        user.setFirstName("Thugger");
        user.setLastName("Fly");
        user.setAge(25);
        user.setJobTitle("Developer");
        user.setBirthdate(new Date(1994, Calendar.MARCH, 3));
        this.userRepository.save(user);

        Category category = new Category();
        category.setCategoryName("Java");
        category.setDescription("Tout ce qui concerne le langage Java");
        this.categoryRepository.save(category);
 */
 }
}