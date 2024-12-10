package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.*;
import com.example.realEstateCk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private LocationService locationService;
//    @GetMapping("/properties")
//    public String viewHomeProperty(Model model) {
//        List<Property> properties = (List<Property>)propertyService.getAllProperty();
//        model.addAttribute("listProperties", properties);
//        return "properties";
//    }

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

        List<Category> categories = ( List<Category>)categoryService.getAllCategories();
        List<Location> locations = (List<Location>)locationService.getAllLocations();

        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);

        return "properties";
    }


//    @GetMapping("/properties/{id}")
//    public String detailsProperty(@PathVariable("id") Long id, Model model) {
//        Property property = propertyService.getPropertyById(id);
//        model.addAttribute("property", property);
//        PropertyDetails  propertyDetails = propertyDetailsService.getPropertyDetailsById(property.getId());
//        if(propertyDetails != null) {
//            model.addAttribute("propertyDetails", propertyDetails);
//        } else {
//            model.addAttribute("propertyDetails", null);
//        }
//
//        return "properties-single";
//    }


    @GetMapping("/properties/{id}")
    public String detailsProperty(@PathVariable("id") Long id, Model model) {
        Property property = propertyService.getPropertyById(id);

        if (property == null) {
            // Nếu không tìm thấy Property, chuyển hướng hoặc hiển thị trang lỗi
            return "redirect:/properties?error=not-found";
        }

        // Truyền toàn bộ đối tượng Property sang View
        model.addAttribute("property", property);

        // Truyền thêm dữ liệu chi tiết nếu có
        PropertyDetails propertyDetails = propertyDetailsService.getPropertyDetailsById(property.getId());
        model.addAttribute("propertyDetails", propertyDetails);


        model.addAttribute("activePage", "properties");

        return "properties-single";
    }

    @GetMapping("/properties-single")
    public String propertiesPage() {
        return "properties-single";
    }

    @GetMapping("/properties/search")
    public String searchProperties(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long locationId,
            @RequestParam(required = false) String priceRange,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            Model model) {

        Double minPrice = null;
        Double maxPrice = null;

        // Xử lý priceRange (ví dụ: "500000000-800000000")
        if (priceRange != null && priceRange.contains("-")) {
            String[] prices = priceRange.split("-");
            minPrice = Double.valueOf(prices[0]);
            maxPrice = Double.valueOf(prices[1]);
        }

        Page<Property> properties = propertyService.findPropertiesByFilters(categoryId, locationId, minPrice, maxPrice, PageRequest.of(page, size));
        System.out.println(
                "properties: " + properties + "\n"
                        + "categoryId: " + categoryId + "\n"
                        + "locationId: " + locationId + "\n"
                        + "minPrice: " + minPrice + "\n"
                        + "maxPrice: " + maxPrice + "\n"
        );

        if (properties.isEmpty()) {
            model.addAttribute("errorMessage", "No properties found for the selected filters.");
        }

        model.addAttribute("listProperties", properties);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", properties.getTotalPages());
        model.addAttribute("activePage", properties);

        List<Category> categories =( List<Category>) categoryService.getAllCategories();
        List<Location> locations = ( List<Location>)locationService.getAllLocations();

        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);

        // Thêm các tham số lọc vào model để tiếp tục hiển thị bộ lọc
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("locationId", locationId);
        model.addAttribute("priceRange", priceRange);

        return "properties";
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
