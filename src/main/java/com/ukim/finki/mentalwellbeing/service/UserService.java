package com.ukim.finki.mentalwellbeing.service;

import com.ukim.finki.mentalwellbeing.model.User;
import com.ukim.finki.mentalwellbeing.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    User register(String username,String email, String password, String repeatPassword, Role role);

    Optional<User> findByUsername(String username);

    User getUsername(String username);

    UserDetails loadUserByUsername(String s);

}
