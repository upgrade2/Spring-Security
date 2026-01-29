package com.coding.shuttel.learn.exception;

import com.coding.shuttel.learn.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> handelNullPointerException(NullPointerException exception){
        ApiResponse apiResponse = new ApiResponse(exception.getLocalizedMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handelException(Exception exception){
        ApiResponse apiResponse = new ApiResponse(exception.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
