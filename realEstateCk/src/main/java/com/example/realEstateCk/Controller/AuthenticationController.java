package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.UserRepository;
import com.example.realEstateCk.service.AuthenticationService;
import com.example.realEstateCk.utils.AuthenticationRequest;
import com.example.realEstateCk.utils.AuthenticationResponse;
import com.example.realEstateCk.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/login")
    public String login() {
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
//    @PostMapping("/authenticate")
//    @ResponseBody
//    public ResponseEntity<?> authenticate(@ModelAttribute("authenticationRequest") AuthenticationRequest request) {
//        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
//        if(authenticationResponse != null){
//            return ResponseEntity.status(HttpStatus.OK).body(authenticationResponse);
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }

    @PostMapping("/authenticate")
    public RedirectView authenticate(@ModelAttribute("authenticationRequest") AuthenticationRequest request) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        if(authenticationResponse != null){
            return new RedirectView("/");
        }
        return new RedirectView("/api/auth/login");
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