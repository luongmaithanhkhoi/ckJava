package com.example.realEstateCk.service;

import com.example.realEstateCk.model.User;

import java.security.Principal;

public interface UserService {
    public void save(User user);
    public User findByEmail(String email);
    public User update(User user);
    public User findById(Long id);
    boolean deleteUser(Long id);

    boolean verifyUser(String code);
    boolean changePassword(Principal connectedUser, String currentPassword, String newPassword, String confirmPassword);
}
