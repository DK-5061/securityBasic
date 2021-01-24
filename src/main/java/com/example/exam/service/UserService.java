package com.example.exam.service;

import com.example.exam.model.User;
import com.example.exam.model.UserDTO;
import com.example.exam.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUserAccount (UserDTO userDTO){

        userRepository.save(User.builder()
                .username(userDTO.getFirstName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role("ROLE_USER")
                .build());

    }
}
