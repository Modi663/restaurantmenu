package com.example.restaurantmenu.service;

import com.example.restaurantmenu.model.Item;
import com.example.restaurantmenu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
