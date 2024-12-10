package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;
import com.example.realEstateCk.service.PropertyDetailsService;
import com.example.realEstateCk.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyDetailsService propertyDetailsService;

    @GetMapping("/properties")
    public String viewHomeProperty(Model model) {
        List<Property> properties = (List<Property>)propertyService.getAllProperty();
        model.addAttribute("listProperties", properties);
        return "properties";
    }

    @GetMapping("/properties/{id}")
    public String detailsProperty(@PathVariable("id") Long id, Model model) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
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

}
