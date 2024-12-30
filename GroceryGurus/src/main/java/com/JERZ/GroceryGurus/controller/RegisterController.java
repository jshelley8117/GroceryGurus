package com.JERZ.GroceryGurus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JERZ.GroceryGurus.entity.User;
import com.JERZ.GroceryGurus.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/")
public class RegisterController {

    @Autowired
    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    private final UserService userService;

    public RegisterController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User u, HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        try {
            String preEncodedPassword = u.getPassword();
            this.userService.create(u);
            Authentication authenticationRequest = new UsernamePasswordAuthenticationToken(u.getUsername(), preEncodedPassword);
            Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationResponse);
            SecurityContextHolder.setContext(securityContext);
            securityContextRepository.saveContext(securityContext, request, response);
            return ResponseEntity.ok("Successfully registered and logged in");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage() + " " + u.getUsername() + " " + u.getPassword());
        }
    }
    
}
