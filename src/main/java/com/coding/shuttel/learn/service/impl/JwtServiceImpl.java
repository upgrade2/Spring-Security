package com.coding.shuttel.learn.service.impl;

import com.coding.shuttel.learn.repository.entity.User;
import com.coding.shuttel.learn.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    private SecretKey getSecretKey(){return Keys.h}
    @Override
    public String generateAccessToken(User user) {
        return null;
    }

    @Override
    public Long getUserIdFromToken(String token) {
        return null;
    }
}
