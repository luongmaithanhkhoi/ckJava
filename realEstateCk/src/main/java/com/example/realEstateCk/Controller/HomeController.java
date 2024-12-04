package com.example.realEstateCk.Controller;

import com.example.realEstateCk.Model.RealEstate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.realEstateCk.Service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RealEstateService realEstateService;

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
    public String propertiesPage(Model model) {
        List<RealEstate> properties = realEstateService.getAllRealEstates();

        // Định dạng giá trị price
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        for (RealEstate realEstate : properties) {
            String formattedPrice = "$" + formatter.format(realEstate.getPrice());
            realEstate.setFormattedPrice(formattedPrice); // set price formatted
        }

        model.addAttribute("realEstates", properties);
        return "properties";
    }

    @GetMapping("/properties-single")
    public String propertiesSinglePage() {
        return "properties-single";
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
