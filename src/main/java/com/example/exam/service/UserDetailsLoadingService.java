package com.example.exam.service;

import com.example.exam.model.UserPrincipal;
import com.example.exam.model.User;
import com.example.exam.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsLoadingService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(s);
       return Optional.ofNullable(user).map(UserPrincipal::new).orElseThrow();
    }
}
