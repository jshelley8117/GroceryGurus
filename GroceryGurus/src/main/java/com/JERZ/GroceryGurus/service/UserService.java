package com.JERZ.GroceryGurus.service;

import org.springframework.stereotype.Service;

import com.JERZ.GroceryGurus.entity.User;
import com.JERZ.GroceryGurus.repository.UserRepository;

import java.util.Optional;
import java.util.List;
@Service

public class UserService {
    
    private final UserRepository userRepository;
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
