package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.User;
import com.example.realEstateCk.service.AuthenticationService;
import com.example.realEstateCk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/user/forgotPassword")
    @ResponseBody
    public String forgotPassword(@RequestParam String email) {
        if(authenticationService.forgotPassword(email)){
            return "Kiểm tra email để lấy mật khẩu mới";
        }
        return "Email không tồn tại hoặc chưa đăng ký tài khoản!";
    }
    @PatchMapping("/user/changePassword")
    @ResponseBody
    public String changePassword(Principal connectedUser, @RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        if(userService.changePassword(connectedUser, currentPassword, newPassword, confirmPassword)){
            return "Doi mat khau thanh cong";
        }
        return "Doi mat khau khong thanh cong";

    }

    @GetMapping("/user/current-user")
    @ResponseBody
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String username = authentication.getName();
            return "Current User: " + username;
        } else {
            return "No user logged in";
        }
    }












}
