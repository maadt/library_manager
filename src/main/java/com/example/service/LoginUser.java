package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;



public class LoginUser implements UserDetails {
// UserDetails：認証されたユーザーの詳細情報を提供する

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
    
    public Integer getUserId() {
        return user.getId(); 
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	return AuthorityUtils.NO_AUTHORITIES;	
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}