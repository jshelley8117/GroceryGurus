package com.JERZ.GroceryGurus.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.JERZ.GroceryGurus.entity.User;
import com.JERZ.GroceryGurus.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("SqlUserDetailsService")
public class SqlUserDetailsService implements UserDetailsService  {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("SqlUserDetailsService.loadUserByUsername: username = " + username);
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()) return optionalUser.get();
        throw new UsernameNotFoundException("User not found with email: " + username);
    }
}
