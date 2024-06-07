package com.example.restaurantmenu.controller;

import com.example.restaurantmenu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home() {
        return "public/home";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "public/menu";
    }

    @GetMapping("/contact")
    public String contact() {
        return "public/contact";
    }
}
