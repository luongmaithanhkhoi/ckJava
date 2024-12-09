package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Category;
import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;
import com.example.realEstateCk.model.User;
import com.example.realEstateCk.service.CategoryService;
import com.example.realEstateCk.service.PropertyDetailsService;
import com.example.realEstateCk.service.PropertyService;
import com.example.realEstateCk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PropertyController {
    @Autowired
    private UserService userService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyDetailsService propertyDetailsService;
    @Autowired
    private CategoryService categoryService;
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

    @GetMapping("/propertiesList")
    public String listPropertiesPage(Model model) {
        List<Property> properties = (List<Property>)propertyService.findByOwnerId(1L);
        model.addAttribute("listProperties", properties);

        return "/Admin/listProprties";
    }
    @GetMapping("/propertiesList/edit/{id}")
    public String editItem(@PathVariable("id") Long id, Model model) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        List<Category> categoryList = (List<Category>) categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/Admin/editProprties";
    }

    @PostMapping("/propertiesList/edit/{id}")
    public String saveEditItem(@PathVariable("id") Long id, Model model, Property propertyEdit) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        User user = userService.findById(1L);
        propertyEdit.setOwner(user);
        propertyService.save(propertyEdit);
        return "redirect:/propertiesList";
    }

//    @GetMapping("/propertiesList/delete/{id}")
//    public String deleteProperty(@PathVariable("id") Long id, RedirectAttributes redirectAttribute) {
//        PropertyDetails a = propertyDetailsService.findPropertyDetailsByIdProperty(propertyService.getPropertyById(id));
//        propertyDetailsService.deletePropertyDetails(a);
//        propertyService.deleteById(id);
//        redirectAttribute.addFlashAttribute("success","Item deleted!");
//        return "/Admin/listProprties";
//    }

}
