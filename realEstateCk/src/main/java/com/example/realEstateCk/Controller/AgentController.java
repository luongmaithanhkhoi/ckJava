package com.example.realEstateCk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgentController {
    @GetMapping("/seller")
    public String login() {
        return "/Admin/index";
    }
}
