package com.example.realEstateCk.security;

import com.example.realEstateCk.model.User;

public interface JwtService {
    String generateToken(User user);
    String extractUsername(String token);

}
