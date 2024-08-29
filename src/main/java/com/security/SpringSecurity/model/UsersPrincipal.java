package com.security.SpringSecurity.model;

import com.security.SpringSecurity.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UsersPrincipal implements UserDetails {


    private Users user;

    public  UsersPrincipal(Users user){
        this.user =user;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USERS"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        // You can customize this based on your application logic
        return true; // Assuming accounts never expire
    }

    @Override
    public boolean isAccountNonLocked() {
        // Customize this based on your application logic
        return true; // Assuming accounts are never locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Customize this based on your application logic
        return true; // Assuming credentials never expire
    }

    @Override
    public boolean isEnabled() {
        // Customize this based on your application logic
        return true; // Assuming the user is always enabled
    }
}
