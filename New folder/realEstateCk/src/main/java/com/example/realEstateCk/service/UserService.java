package com.example.realEstateCk.service;

import com.example.realEstateCk.model.User;

public interface UserService {
    public void save(User user);
    public User findByEmail(String email);
    public User update(User user);
    public User findById(Long id);
}
