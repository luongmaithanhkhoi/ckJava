package com.example.realEstateCk.service;


import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User updateUser(Long id, User user) {
        User existUser = userRepository.findById(id).orElse(null);
        if(existUser != null) {
            existUser.setUsername(user.getUsername());
            existUser.setPassword(user.getPassword());
            return userRepository.save(existUser);
        }
        return null;
    }

    @Override
    public void deleteAccount(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean verifyUser(String code) {
        try{
            User user = userRepository.findByVerificationCode(code);
            if (user != null) {
                user.setEmailVerified(true);
                user.setVerificationCode(null);
                userRepository.save(user);
                return true;
            }
        }catch (Exception e){
            return false;
        }

        return false;
    }
    @Override
    public boolean changePassword(Principal connectedUser, String currentPassword, String newPassword, String confirmPassword){
        try{
            User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

            if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
                throw new IllegalStateException("Wrong password");
            }
            if (!newPassword.equals(confirmPassword)) {
                throw new IllegalStateException("Password are not the same");
            }

            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
