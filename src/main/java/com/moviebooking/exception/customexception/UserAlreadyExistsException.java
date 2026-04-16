package com.moviebooking.exception.customexception;

import com.moviebooking.UserServiceApplication;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){
        super(message);
    }

}
