package com.JERZ.GroceryGurus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JERZ.GroceryGurus.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
    
}
