package com.coding.shuttel.learn.service;

import com.coding.shuttel.learn.dto.LoginRequestDTO;
import com.coding.shuttel.learn.dto.LoginResponseDTO;

public interface AuthService {
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
