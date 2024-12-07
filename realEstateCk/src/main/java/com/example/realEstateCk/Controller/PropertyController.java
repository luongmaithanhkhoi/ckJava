package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Category;
import com.example.realEstateCk.model.Location;
import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;
import com.example.realEstateCk.service.CategoryService;
import com.example.realEstateCk.service.LocationService;
import com.example.realEstateCk.service.PropertyDetailsService;
import com.example.realEstateCk.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyDetailsService propertyDetailsService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/properties")
    public String viewHomeProperty(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            Model model) {
//        List<Property> properties = (List<Property>)propertyService.getAllProperty();
//        model.addAttribute("listProperties", properties);

        Page<Property> properties = propertyService.getAllProperty(page, size);
        model.addAttribute("realEstates", properties.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", properties.getTotalPages());
        model.addAttribute("listProperties", properties);
        model.addAttribute("activePage", "properties");

        List<Category> categories = categoryService.getAllCategories();
        List<Location> locations = locationService.getAllLocations();

        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);

        return "properties";
    }

    @GetMapping("/properties/{id}")
    public String detailsProperty(@PathVariable("id") Long id, Model model) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        model.addAttribute("activePage", "properties");
        PropertyDetails  propertyDetails = propertyDetailsService.getPropertyDetailsById(property.getId());
        if(propertyDetails != null) {
            model.addAttribute("propertyDetails", propertyDetails);
        } else {
            model.addAttribute("propertyDetails", null);
        }

        return "properties-single";
    }

    @GetMapping("/properties-single")
    public String propertiesPage() {

        return "properties-single";
    }

//    @GetMapping("/property-search")
//    public String showSearchForm(Model model) {
//        List<Category> categories = categoryService.getAllCategories();
//        List<Location> locations = locationService.getAllLocations();
//
//        model.addAttribute("listProperties", categories);
//        model.addAttribute("listLocations", locations);
//        return "property-search";
//    }

}
