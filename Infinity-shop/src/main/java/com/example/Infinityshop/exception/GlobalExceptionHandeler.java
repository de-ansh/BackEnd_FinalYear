package com.example.Infinityshop.exception;

import com.example.Infinityshop.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ressourceNotFoundExceptionHandeler(ResourceNotFoundException ex){
        String messages= ex.getMessage();
        ApiResponse apiResponse= new ApiResponse(messages, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
