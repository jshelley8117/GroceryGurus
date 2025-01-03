package com.JERZ.GroceryGurus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JERZ.GroceryGurus.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
