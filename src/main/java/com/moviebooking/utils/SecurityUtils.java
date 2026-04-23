package com.moviebooking.utils;

import com.moviebooking.entity.User;
import com.moviebooking.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    public static String getCurrentUserEmail(){
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        return (String) auth.getPrincipal();
    }

    public static User getCurrentUser(UserRepository userRepository) {
        String email = getCurrentUserEmail();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
