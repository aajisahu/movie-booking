package com.moviebooking.service;

import com.moviebooking.dto.request.RegisterRequest;
import com.moviebooking.entity.User;
import com.moviebooking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    //Constructor Injection
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // register user
    public void registerUser(RegisterRequest registerRequest){
        log.info("Register request received for email id: {}", registerRequest.getEmail());
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            log.warn("Registration failed: Email already exists - {}", registerRequest.getEmail());
            throw new RuntimeException("Email already exists");
        }

        String encodePassword = passwordEncoder.encode(registerRequest.getPassword());
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(encodePassword)
                .build();
        userRepository.save(user);
        log.info("User registered successfully with email: {}", registerRequest.getEmail());

    }

    // Login user
    public boolean login(String email, String password){
        log.info("Login attempt for email: {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("Login failed: User not found for email: {}", email);
                    return new RuntimeException("Invalid user");
                });
        boolean isValid = passwordEncoder.matches(password, user.getPassword());

        if (isValid) {
            log.info("Login successful");
            return isValid;
        } else {
            log.warn("Invalid password");
            return isValid;
        }
    }
}
