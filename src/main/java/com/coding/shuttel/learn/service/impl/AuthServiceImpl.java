package com.coding.shuttel.learn.service.impl;

import com.coding.shuttel.learn.dto.LoginRequestDTO;
import com.coding.shuttel.learn.dto.LoginResponseDTO;
import com.coding.shuttel.learn.repository.entity.User;
import com.coding.shuttel.learn.service.AuthService;
import com.coding.shuttel.learn.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),loginRequestDTO.getPassword(), Collections.emptyList())
        );
        User user = (User)authentication.getPrincipal();
        String accessToken = jwtService.generateAccessToken(user);

        return new LoginResponseDTO(user.getId(),accessToken);
    }
}
