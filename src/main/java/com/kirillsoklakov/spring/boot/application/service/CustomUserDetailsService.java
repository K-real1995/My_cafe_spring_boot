package com.kirillsoklakov.spring.boot.application.service;


import com.kirillsoklakov.spring.boot.application.model.User;
import com.kirillsoklakov.spring.boot.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.LoadUserByUsername(login);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUser(user);
    }
}
