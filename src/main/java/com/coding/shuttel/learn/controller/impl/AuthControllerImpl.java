package com.coding.shuttel.learn.controller.impl;

import com.coding.shuttel.learn.controller.AuthController;
import com.coding.shuttel.learn.dto.*;
import com.coding.shuttel.learn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final UserService userService;

    @Override
    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse> signup(@RequestBody SignUpDTO signUpDTO) {
       ApiResponse apiResponse = new ApiResponse("Data saved Successfully", HttpStatus.CREATED);
       apiResponse.setData(userService.signUp(signUpDTO));
       return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
