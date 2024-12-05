package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/a")
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
//    @GetMapping("/properties")
//    public String propertiesPage() {
//        return "properties";
//    }

    @GetMapping("/")
    public String viewProperty(Model model) {
        List<Property> properties = (List<Property>)propertyService.getAllProperty();
        model.addAttribute("listHomeProperties", properties);
        return "index";
    }
}
