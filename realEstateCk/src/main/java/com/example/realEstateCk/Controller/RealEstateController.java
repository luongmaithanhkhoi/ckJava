package com.example.realEstateCk.Controller;

import com.example.realEstateCk.Model.RealEstate;
import com.example.realEstateCk.Service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/properties")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @GetMapping
    public String listProperties(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            Model model) {
        Page<RealEstate> realEstatePage = realEstateService.getRealEstates(page, size);
        model.addAttribute("realEstates", realEstatePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", realEstatePage.getTotalPages());
        return "properties";
    }
}
