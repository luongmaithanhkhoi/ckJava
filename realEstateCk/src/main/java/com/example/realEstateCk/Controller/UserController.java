package com.example.realEstateCk.Controller;

import com.example.realEstateCk.service.AuthenticationService;
import com.example.realEstateCk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
