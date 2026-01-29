package com.coding.shuttel.learn.controller;

import com.coding.shuttel.learn.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PostController {
    public ResponseEntity<ApiResponse> getListOfAllEmployee();

}
