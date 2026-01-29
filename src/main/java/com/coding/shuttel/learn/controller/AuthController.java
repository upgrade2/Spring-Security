package com.coding.shuttel.learn.controller;

import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.dto.LoginRequestDTO;
import com.coding.shuttel.learn.dto.LoginResponseDTO;
import com.coding.shuttel.learn.dto.SignUpDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthController {
    public ResponseEntity<ApiResponse> signup(SignUpDTO signUpDTO);
    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO, HttpServletRequest request, HttpServletResponse response);

}
