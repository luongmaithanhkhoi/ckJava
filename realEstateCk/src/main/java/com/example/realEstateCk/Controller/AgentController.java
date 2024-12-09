package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.*;
import com.example.realEstateCk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class AgentController {
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

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/seller")
    public String login(Model model) {
//
        Long id = 1L; /////////////////// chinh code
        User user = userService.findById(id);
        model.addAttribute("user", user);
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getInstance(vietnamLocale);
        String formattedMoney = currencyFormat.format(user.getMoney());

        List<Property> listProperties = (List<Property>) propertyService.findByOwnerId(id);
        int numberOfProperties = listProperties.size();
        model.addAttribute("total", numberOfProperties);
        model.addAttribute("user", user);
        model.addAttribute("formattedMoney", formattedMoney);
        return "/Admin/index";
    }
    @GetMapping("/postnew")
    public String postNew(Model model) {
        List<Property> properties = (List<Property>)propertyService.getAllProperty();
        model.addAttribute("listProperties", properties);
        return "/Admin/postNew";
    }

    @GetMapping("/postnew/add")
    public String addProperty(Model model) {
//        model.addAttribute("property", new Property());
//        model.addAttribute("propertyDetails", new PropertyDetails());
        model.addAttribute("propertyForm", new PropertyFormDTO());
        List<Property> listProperty =(List<Property>) propertyService.getAllProperty();
        List<Category> categoryList = (List<Category>) categoryService.getAllCategories();
        model.addAttribute("listProperties", listProperty);
        model.addAttribute("categoryList", categoryList);
        return "/Admin/postNewAdd";
    }

    @PostMapping("/postnew/save")
    public String saveProperty(@ModelAttribute PropertyFormDTO propertyFormDTO, @RequestParam("itemImage") MultipartFile imgFile, RedirectAttributes redirectAttribute){
        Property newProperty = propertyFormDTO.getProperty();
        PropertyDetails propertyDetails = propertyFormDTO.getPropertyDetails();
        String cityId = propertyDetails.getCity();
        String districtId = propertyDetails.getState();
        String wardId = propertyDetails.getType();
        String cityName = locationService.getCityName(cityId); // Tên quận huyện
        String districtName = locationService.getDistrictName(cityId, districtId); // Tên quận huyện
        String wardName = locationService.getWardName(cityId, districtId, wardId); // Tên phường xã
        propertyDetails.setCity(cityName);
        propertyDetails.setState(districtName);
        propertyDetails.setType(wardName);
        newProperty.setLocation(propertyDetails.getLocation() +' '+ wardName + ' '+ districtName + ' '+ cityName);
        newProperty.setOwner(userService.findById(1L));
        newProperty.setStatus("Available");
        newProperty.setType("PENDING_PAYMENT");
        propertyService.save(newProperty);
        propertyDetails.setProperties(propertyService.getPropertyById(newProperty.getId()));
        propertyDetails.setPrice(1999);
        propertyDetails.setFloor("Khong co thong tin");
        propertyDetails.setMethodpost("bth");
        if(newProperty.getMethod() == 0) {
            propertyDetails.setStype("Cho thue");
        } else {
            propertyDetails.setStype("Ban");
        }
        propertyDetailsService.savePropertyDetails(propertyDetails);
        return "/Admin/listComfirPayment";
    }
    @GetMapping("/postnew/listpost")
    public String listPost(Model model) {
        Long id = 1L;
        User user = userService.findById(id);
        model.addAttribute("user", user);
        List<Property> listProperties = (List<Property>) propertyService.findByOwnerId(1L);
        model.addAttribute("listProperties", listProperties);
        return "/Admin/listComfirPayment";
    }

    @GetMapping("/postnew/confirmPayment/{id}")
    public String confirmPayment(@PathVariable("id") Long id, Model model) {
        Long idUser = 1L;
        User user = userService.findById(idUser);
        model.addAttribute("user", user);
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getInstance(vietnamLocale);
        String formattedMoney = currencyFormat.format(user.getMoney());
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        model.addAttribute("formattedMoney", formattedMoney);
        model.addAttribute("user", user);
        return "/Admin/comfirPayment";
    }

    @PostMapping("/postnew/confirmPayment/save")
    public RedirectView confirmPaymentSave(
            @RequestParam("adType") String adType,
            @RequestParam("adDuration") String adDuration,
            @RequestParam("propertyId") Long propertyId,
            Model model) {
        RedirectView redirectView = new RedirectView();
        Long id = 1L;
        User user = userService.findById(id);
        double price = calculatePrice(adType, adDuration);
        if(adType.equals("vip1") && adDuration.equals("30") ) {
            model.addAttribute("message", "Lỗi vui lòng kiểm tra lại");
            redirectView.setUrl("/postnew/confirmPayment/" + propertyId);
            return redirectView;
        }
        if(adType.equals("vip2") && adDuration.equals("30") ) {
            model.addAttribute("message", "Lỗi vui lòng kiểm tra lại");
            redirectView.setUrl("/postnew/confirmPayment/" + propertyId);
            return redirectView;
        }
        if (price < 0 || price > user.getMoney()) {
            model.addAttribute("message", "Lỗi vui lòng kiểm tra lại");
            redirectView.setUrl("/postnew/confirmPayment/" + propertyId);
            return redirectView;
        } else {
            long moneyLong = user.getMoney();
            Double money = (double) moneyLong;
            Double tt = money - price;
            user.setMoney(tt.longValue());
            userService.save(user);
            Transaction transaction = new Transaction();
            transaction.setSeller(user);
            Property property = propertyService.getPropertyById(propertyId);
//            PropertyDetails propertyDetails = propertyDetailsService.getPropertyDetailsByIdPro(propertyId);
            transaction.setProperty(property);
            transaction.setStatus("Completed");
            BigDecimal priceBig = new BigDecimal(price);
            transaction.setPrice(priceBig);
            transactionService.save(transaction);
            property.setType("Completed");
            propertyService.save(property);

//            int adDurationInt = Integer.parseInt(adDuration);
//            propertyDetails.setTime(adDurationInt);
//            propertyDetailsService.savePropertyDetails(propertyDetails);
//            System.out.println(adDuration);
        }
        redirectView.setUrl("/postnew/listpost");
        return redirectView;
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
