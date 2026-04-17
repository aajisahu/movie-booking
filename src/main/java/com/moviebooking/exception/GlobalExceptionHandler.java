package com.moviebooking.exception;

import com.moviebooking.dto.response.ErrorResponses;
import com.moviebooking.exception.customexception.InvalidCredentialsException;
import com.moviebooking.exception.customexception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponses> handleUserExist(UserAlreadyExistsException ex){
        ErrorResponses error = new ErrorResponses(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<ErrorResponses>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponses> handleGeneric (RuntimeException ex){
        ErrorResponses error = new ErrorResponses(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponses> handleInvalidCredentials(InvalidCredentialsException ex) {

        ErrorResponses error = new ErrorResponses(
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.value()
        );

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
