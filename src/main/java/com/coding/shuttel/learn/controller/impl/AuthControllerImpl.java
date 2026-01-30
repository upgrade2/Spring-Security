package com.coding.shuttel.learn.controller.impl;

import com.coding.shuttel.learn.controller.AuthController;
import com.coding.shuttel.learn.dto.*;
import com.coding.shuttel.learn.service.AuthService;
import com.coding.shuttel.learn.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final UserService userService;
    private final AuthService authService;

    @Value("${deploy.env}")
    private String deployEnv;
    @Override
    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse> signup(@RequestBody SignUpDTO signUpDTO) {
       ApiResponse apiResponse = new ApiResponse("Data saved Successfully", HttpStatus.CREATED);
       apiResponse.setData(userService.signUp(signUpDTO));
       return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request, HttpServletResponse response) {
        LoginResponseDTO loginResponseDTO=authService.login(loginRequestDTO);
        Cookie cookie = new Cookie("refreshToken",loginResponseDTO.getRefreshToken());
        cookie.setHttpOnly(true);
        cookie.setSecure("prod".equals(deployEnv));
        response.addCookie(cookie);

        return ResponseEntity.ok(loginResponseDTO);
    }

    @Override
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDTO> refresh(HttpServletRequest request) {
     String refreshToken=Arrays.stream(request.getCookies())
              .filter(cookie -> "refreshToken".equals(cookie.getName()))
              .findFirst()
              .map(Cookie::getValue)
              .orElseThrow(()-> new AuthenticationServiceException("Refresh token not found inside the cookies"));
     LoginResponseDTO loginResponseDTO = authService.refresh(refreshToken);
        return ResponseEntity.ok(loginResponseDTO);
    }
}
