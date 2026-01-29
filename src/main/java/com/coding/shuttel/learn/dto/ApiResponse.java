package com.coding.shuttel.learn.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private LocalDateTime timeStamp;
    private Object data;
    private String message;
    private HttpStatus statusCode;

    ApiResponse(){this.timeStamp=LocalDateTime.now();}
    public ApiResponse(String message, HttpStatus statusCode){
        this();
        this.message=message;
        this.statusCode=statusCode;
    }
}
