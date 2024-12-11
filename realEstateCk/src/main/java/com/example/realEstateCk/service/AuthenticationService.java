package com.example.realEstateCk.service;


import com.example.realEstateCk.utils.AuthenticationRequest;
import com.example.realEstateCk.utils.AuthenticationResponse;
import com.example.realEstateCk.utils.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    boolean forgotPassword(String email);
}
