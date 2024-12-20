package com.JERZ.GroceryGurus.service;

import org.springframework.stereotype.Service;

import com.JERZ.GroceryGurus.entity.Authority;
import com.JERZ.GroceryGurus.repository.AuthorityRepository;

import java.util.Optional;
import java.util.List;
@Service

public class AuthorityService {
  
    private final AuthorityRepository authorityRepository;
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public List<Authority> findAll() {
        return this.authorityRepository.findAll();
    }

    public Authority findById(Integer id) {
        Optional<Authority> optAuthority = authorityRepository.findById(id);
        return optAuthority.orElse(null);
    }

    public void create(Authority a) {
        this.authorityRepository.save(a);
    }

    public Authority update(Authority a, Integer id) {
        Optional<Authority> optAuthority = this.authorityRepository.findById(id);
        if (!optAuthority.isPresent()) return null;
        Authority authority = optAuthority.get();
        if (a.getUsername() != null) {
            authority.setUsername(a.getUsername());
        }
        if (a.getAuthority() != null) {
            authority.setAuthority(a.getAuthority());
        }
        return authorityRepository.save(authority);
    }
    public void delete(Integer id) {
        this.authorityRepository.deleteById(id);
    }
}
