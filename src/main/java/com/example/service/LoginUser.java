package com.example.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;



public class LoginUser implements UserDetails {

    private final User user;

    public LoginUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }
}