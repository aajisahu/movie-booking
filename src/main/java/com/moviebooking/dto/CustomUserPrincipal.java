package com.moviebooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomUserPrincipal {
    private String email;
    private String role;

}
