package com.moviebooking.dto.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor

public class UserResponse {
    private String name;
    private String email;

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", email='" + email + '\'';
    }
}
