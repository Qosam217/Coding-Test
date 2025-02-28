package com.example.coding_test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coding_test.entities.Item;
import com.example.coding_test.repositories.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepo;

    public List<Item> getAllItems(Long id){
        return itemRepo.findAllItemByChecklistId(id);
    }

    public String getDetailItem(Long id){
        Item item = itemRepo.findById(id).orElse(null);
        return item.getDetail();
    }

    public Item createItem(Item item){
        return itemRepo.save(item);
    }

    public Item updateItem(Item item, Long id){
        Item requestItem = itemRepo.findById(id).orElse(null);
        requestItem.setDetail(item.getDetail());
        return itemRepo.save(requestItem);
    }

    public Item checkItem(Long id){
        Item item = itemRepo.findById(id).orElse(null);
        item.setChecked(true);
        return itemRepo.save(item);
    }

    public void deleteItem(Long id){
        Item item = itemRepo.findById(id).orElse(null);
        item.setIsDeleted(true);
        itemRepo.save(item);
    }
}
