package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.UserRepository;
import com.example.realEstateCk.utils.AuthenticationRequest;
import com.example.realEstateCk.utils.AuthenticationResponse;
import com.example.realEstateCk.utils.RegisterRequest;
import com.example.realEstateCk.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth/")
@Controller
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String register() {
        return "login";
    }
    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute("registerRequest") RegisterRequest registerRequest) {
        try{
            AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);
            return "Đăng ký thành công. Vui lòng xác minh email của bạn";

        }catch (Exception e){
            return "Đăng ký không thành công";
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam String code) {
        User user = userRepository.findByVerificationCode(code);
        user.setEmailVerified(true);
        user.setVerificationCode(null);
        userRepository.save(user);
        return "Success";
    }

}
