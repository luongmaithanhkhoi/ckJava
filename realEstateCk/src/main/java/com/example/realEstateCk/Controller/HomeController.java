package com.example.realEstateCk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class    HomeController {
    @GetMapping("/")
    public String login() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/agent")
    public String agentPage() {
        return "agent";
    }

    @GetMapping("/services")
    public String servicesPage() {
        return "services";
    }

    @GetMapping("/properties")
    public String propertiesPage() {
        return "properties";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
