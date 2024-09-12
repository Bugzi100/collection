package com.example.collection.controller;

import com.example.collection.model.Item;
import com.example.collection.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item itemDetails) {
        Item updatedItem = itemService.updateItem(id, itemDetails);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
