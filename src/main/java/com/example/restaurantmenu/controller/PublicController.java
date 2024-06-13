package com.example.restaurantmenu.controller;

import com.example.restaurantmenu.model.Item;
import com.example.restaurantmenu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PublicController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home() {
        return "public/index";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        return "public/menu";
    }

    @GetMapping("/contact")
    public String contact() {
        return "public/contact";
    }

    @GetMapping("/menu-data")
    @ResponseBody
    public ResponseEntity<List<Item>> getMenuData() {
        List<Item> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }
}
