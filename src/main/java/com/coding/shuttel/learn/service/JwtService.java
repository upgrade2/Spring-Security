package com.coding.shuttel.learn.service;

import com.coding.shuttel.learn.repository.entity.User;

public interface JwtService {
    public String generateAccessToken(User user);
    public Long getUserIdFromToken(String token);

}
