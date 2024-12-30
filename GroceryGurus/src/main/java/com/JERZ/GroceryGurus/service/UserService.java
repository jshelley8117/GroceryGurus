package com.JERZ.GroceryGurus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JERZ.GroceryGurus.entity.User;
import com.JERZ.GroceryGurus.repository.UserRepository;

import java.util.Optional;
import java.util.List;
@Service

public class UserService {
    
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> optUser = userRepository.findById(id);
        return optUser.orElse(null);
    }

    public void create(User u) {
        System.out.println("UserService.create: u = " + u);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(true);
        this.userRepository.save(u);
    }

    public User update(User u, Integer id) {
        Optional<User> optUser = this.userRepository.findById(id);
        if (!optUser.isPresent()) return null;
        User user = optUser.get();
        if (u.getUsername() != null) {
            user.setUsername(u.getUsername());
        }
        if (u.getPassword() != null) {
            user.setPassword(u.getPassword());
        }
        if (u.getEnabled() != null) {
            user.setEnabled(u.getEnabled());
        }
        return userRepository.save(user);
    }
    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }

}
