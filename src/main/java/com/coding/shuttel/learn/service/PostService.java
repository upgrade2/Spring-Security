package com.coding.shuttel.learn.service;

import com.coding.shuttel.learn.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {
    public ResponseEntity<ApiResponse> getListOfAllEmployee();
}
