package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.entity.Authority;
import com.JERZ.GroceryGurus.service.AuthorityService;    

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class AuthorityController {
    private final AuthorityService authorityService;
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/authorities")
    public ResponseEntity<List<Authority>> getAllAuthorities() {
        List<Authority> authorities = this.authorityService.findAll();
        return ResponseEntity.ok(authorities);
    }

    @GetMapping("/authorities/{id}")
    public ResponseEntity<Authority> getAuthorityById(@PathVariable("id") Integer id) {
        Authority authority = this.authorityService.findById(id);
        if (authority == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authority);
    }

    @PostMapping("/authorities")
    public ResponseEntity<Authority> createAuthority(@RequestBody Authority a) {
        this.authorityService.create(a);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/authorities/{id}")
    public ResponseEntity<Authority> deleteAuthorityById(@PathVariable("id") Integer id) {
        Authority authority = this.authorityService.findById(id);
        if (authority == null) {
            return ResponseEntity.notFound().build();
        }
        this.authorityService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/authorities/{id}")
    public ResponseEntity<Authority> updateAuthorityById(@PathVariable("id") Integer id, @RequestBody Authority a) {
        Authority updatedAuthority = this.authorityService.update(a, id);
        if (updatedAuthority != null) return ResponseEntity.ok(updatedAuthority);
        return ResponseEntity.notFound().build();
    }
    
}
