package com.example.realEstateCk.service;

import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
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
    @Override
    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
