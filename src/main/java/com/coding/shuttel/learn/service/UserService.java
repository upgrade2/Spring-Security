package com.coding.shuttel.learn.service;

import com.coding.shuttel.learn.repository.entity.User;

public interface UserService {
    public User getUserById(Long id);
    public User getUserByEmail(String email);

}
