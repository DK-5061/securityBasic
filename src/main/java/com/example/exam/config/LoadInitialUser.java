package com.example.exam.config;

import com.example.exam.model.User;
import com.example.exam.model.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadInitialUser {

    public LoadInitialUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        User user = User.builder()
                .username("Marek")
                .password(passwordEncoder.encode("Nowak"))
                .role("ROLE_USER")
                .build();

        User user2 = User.builder()
                .username("Karol")
                .password(passwordEncoder.encode("Kowalski"))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(user);
        userRepository.save(user2);
    }
}
