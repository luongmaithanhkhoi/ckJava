package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Category;
import com.example.realEstateCk.model.CityPropertyDTO;
import com.example.realEstateCk.model.Location;
import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.service.CategoryService;
import com.example.realEstateCk.service.LocationService;
import com.example.realEstateCk.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PropertyService propertyService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

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

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("activePage", "home");
        List<Property> properties = (List<Property>)propertyService.getAllPropertyHome();

        // Giới hạn chỉ lấy 8 sản phẩm
        int limit = Math.min(8, properties.size());
        properties = properties.subList(0, limit);

        model.addAttribute("listHomeProperties", properties);
        List<Category> categories =( List<Category>) categoryService.getAllCategories();
        List<Location> locations = ( List<Location>)locationService.getAllLocations();

        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);


        // Danh sách hình ảnh để gán cho mỗi thành phố
        List<String> images = Arrays.asList("/images/place-1.jpg", "/images/place-2.jpg", "/images/place-3.jpg");
        model.addAttribute("images", images);

        // Lấy danh sách các thành phố có nhiều bất động sản
        List<CityPropertyDTO> topCities = propertyService.getTopCitiesWithMostProperties();
        // Cập nhật image cho từng city
        for (int i = 0; i < topCities.size(); i++) {
            String image = "/images/place-" + (i % 3 + 1) + ".jpg";  // Lặp lại từ place-1 đến place-3
            topCities.get(i).setImage(image);
        }

        model.addAttribute("topCities", topCities);


        return "index";
    }

//    @GetMapping("/")
//    public String viewProperty(Model model) {
//        List<Property> properties = (List<Property>)propertyService.getAllProperty();
//        model.addAttribute("listHomeProperties", properties);
//        return "index";
//    }
}
