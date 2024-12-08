package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Role;
import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.UserRepository;
import com.example.realEstateCk.security.JwtService;
import com.example.realEstateCk.utils.AuthenticationRequest;
import com.example.realEstateCk.utils.AuthenticationResponse;
import com.example.realEstateCk.utils.RegisterRequest;
import com.example.realEstateCk.token.Token;
import com.example.realEstateCk.token.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MailService mailService;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        try{
        User newUser = new User();
        newUser.setFullName(request.getFullName());
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setRole(Role.USER);
        newUser.setEmailVerified(false);
        newUser.setVerificationCode(UUID.randomUUID().toString());
        User createdUser = userRepository.save(newUser);


        mailService.sendMail(createdUser.getEmail(),
                "Verify your Email",
                "Click the link to verify your email: http://localhost:8080/api/auth/verify?code=" + createdUser.getVerificationCode());

        String jwtToken = jwtService.generateToken(createdUser);


        Token token = Token.builder()
                .userId(createdUser.getId())
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        return AuthenticationResponse.builder()
                .user(createdUser)
                .token(jwtToken)
                .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new AuthenticationResponse(null, null);
        }

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()));

            User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            String jwtToken = jwtService.generateToken(user);

            Token token = Token.builder()
                    .userId(user.getId())
                    .token(jwtToken)
                    .expired(false)
                    .revoked(false)
                    .build();
            tokenRepository.save(token);
            return AuthenticationResponse.builder()
                    .user(user)
                    .token(jwtToken)
                    .build();
        }catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }



    @Override
    public boolean forgotPassword(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            String newPassword = generateRandomPassword();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            mailService.sendMail(email,
                    "Bạn vừa dùng email này để lấy mật khẩu mới!",
                    "Mật khẩu mới: " + newPassword);
            return true;
        }
        return false;
    }

    public static String generateRandomPassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            password.append(random.nextInt(10));
        }

        return password.toString();
    }

}
