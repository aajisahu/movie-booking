package com.moviebooking.controller;

import com.moviebooking.dto.request.UpdateUserRequest;
import com.moviebooking.dto.response.UserResponse;
import com.moviebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<String > getProfile(){
        return ResponseEntity.ok("Logged In User: "+ userService.getCurrentUser());
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateProfile(request));
    }

}
