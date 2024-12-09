package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.Category;
import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;
import com.example.realEstateCk.model.User;
import com.example.realEstateCk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
public class PropertyDetailsController {
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

    @GetMapping("/propertiesList/details/edit/{id}")
    public String editItemDetails(@PathVariable("id") Long id, Model model) {
        Property property = propertyService.getPropertyById(id);
        PropertyDetails propertyDetails = propertyDetailsService.findPropertyDetailsByIdProperty(property);
        model.addAttribute("property", property);
        model.addAttribute("propertyDetails", propertyDetails);
        List<Category> categoryList = (List<Category>) categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/Admin/editPropertyDetails";
    }

    @PostMapping("/propertiesList/details/edit/{id}")
    public String saveEditItemDetails(@PathVariable("id") Long id, Model model, PropertyDetails propertyDetailsEdit, @RequestParam("adType") String adType,
                                            @RequestParam("adDuration") String adDuration,
                                            @RequestParam("propertyId") Long propertyId) {

        String cityId = propertyDetailsEdit.getCity();
        String districtId = propertyDetailsEdit.getState();
        String wardId = propertyDetailsEdit.getType();
        String cityName = locationService.getCityName(cityId); // Tên quận huyện
        String districtName = locationService.getDistrictName(cityId, districtId); // Tên quận huyện
        String wardName = locationService.getWardName(cityId, districtId, wardId); // Tên phường xã
        propertyDetailsEdit.setCity(cityName);
        propertyDetailsEdit.setState(districtName);
        propertyDetailsEdit.setType(wardName);
        propertyDetailsEdit.setLocation(propertyDetailsEdit.getLocation() +' '+ wardName + ' '+ districtName + ' '+ cityName);

//        newProperty.setOwner(userService.findById(1L));
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        User user = userService.findById(1L);
       return "/Admin/editPropertyDetails";
    }

    private int calculatePrice(String adType, String adDuration) {

        // Bảng giá
        final Map<String, Map<String, Integer>> priceTable = Map.of(
                "regular", Map.of("7", 0, "10", 36300, "15", 48989, "30", 87120),
                "vip1", Map.of("7", 445199, "10", 604197, "15", 858578, "30", 0),
                "vip2", Map.of("7", 964603, "10", 1309099, "15", 1860310, "30", 0)
        );

        return priceTable.getOrDefault(adType, Map.of()).getOrDefault(adDuration, 0);
    }
}
