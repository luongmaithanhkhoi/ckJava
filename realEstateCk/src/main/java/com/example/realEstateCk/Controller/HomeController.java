package com.example.realEstateCk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/a")
    public String login() {
        return "index";
    }
}
