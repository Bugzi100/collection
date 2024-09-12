package com.example.collection.service;

import com.example.collection.model.Item;
import com.example.collection.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            item.setCategory(itemDetails.getCategory());
            item.setOriginCountry(itemDetails.getOriginCountry());
            item = itemRepository.save(item);
        }
        return null;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
