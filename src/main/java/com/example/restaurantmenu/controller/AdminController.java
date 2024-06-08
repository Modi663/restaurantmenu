package com.example.restaurantmenu.controller;

import com.example.restaurantmenu.model.Item;
import com.example.restaurantmenu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String listItems(Model model){
        model.addAttribute("items", itemService.findAll());
        return  "admin/list-items";
    }

    @GetMapping("/items/add")
    public String addItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "admin/add-item";
    }

    @PostMapping("/items/add")
    public String addItem(@ModelAttribute Item item){
        itemService.save(item);
        return "redirect:/admin/items";
    }

    @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        item.ifPresent(value -> model.addAttribute("item", value));
        return "admin/edit-item";
    }

    @PostMapping("/items/edit/{id}")
    public String editItem(@PathVariable Long id, @ModelAttribute Item item) {
        item.setId(id);
        itemService.save(item);
        return "redirect:/admin/items";
    }

    @PostMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return "redirect:/admin/items";
    }

    @GetMapping
    public String adminRedirect(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "redirect:/admin/items";
        } else {
            return "redirect:/login";
        }
    }
}
