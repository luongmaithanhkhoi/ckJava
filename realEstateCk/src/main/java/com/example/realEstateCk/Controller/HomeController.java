package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("activePage", "home");
        List<Property> properties = (List<Property>)propertyService.getAllPropertyHome();
        model.addAttribute("listHomeProperties", properties);
        return "index";
    }


    @GetMapping("/seller/addMoney")
    public String addMoney() {
        return "/Admin/paypal";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/agent")
    public String agentPage(Model model) {
        model.addAttribute("activePage", "agent");
        return "agent";
    }

    @GetMapping("/services")
    public String servicesPage(Model model) {
        model.addAttribute("activePage", "services");
        return "services";
    }

//    @GetMapping("/properties")
//    public String propertiesPage(Model model) {
//        List<RealEstate> properties = realEstateService.getAllRealEstates();
//
//        // Định dạng giá trị price
//        DecimalFormat formatter = new DecimalFormat("#,###.00");
//        for (RealEstate realEstate : properties) {
//            String formattedPrice = "$" + formatter.format(realEstate.getPrice());
//            realEstate.setFormattedPrice(formattedPrice); // set price formatted
//        }
//
//        model.addAttribute("realEstates", properties);
//        return "properties";
////    }
//
//    @GetMapping("/properties-single")
//    public String propertiesSinglePage() {
//        return "properties-single";
//    }

    @GetMapping("/blog")
    public String blogPage(Model model) {
        model.addAttribute("activePage", "blog");
        return "blog";
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("activePage", "contact");
        return "contact";
    }

}
