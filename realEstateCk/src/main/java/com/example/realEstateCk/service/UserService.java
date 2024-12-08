package com.example.realEstateCk.service;


import com.example.realEstateCk.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    User updateUser(Long id, User user);

    void deleteAccount(Long id);

    User createUser(User user);

    User findUserById(Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findAll();

    boolean verifyUser(String code);
    User findByEmail(String email);
    boolean changePassword(Principal connectedUser, String currentPassword, String newPassword, String confirmPassword);


}
