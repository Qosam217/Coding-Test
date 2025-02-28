package com.example.coding_test.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coding_test.dtos.ItemDto;
import com.example.coding_test.entities.Item;
import com.example.coding_test.services.ItemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all/{id}")
    public ResponseEntity<Object> getAllItems(@PathVariable("id") Long id) {
         Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", itemService.getAllItems(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItem(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", itemService.getDetailItem(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Item item = new Item();
            item.setDetail(dto.getDetail());
            response.put("data", itemService.createItem(item));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/check/{id}")
    public ResponseEntity<Object> checkingItem(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", itemService.checkItem(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable("id") Long id, @RequestBody ItemDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Item item = new Item();
            item.setDetail(dto.getDetail());
            response.put("data", itemService.updateItem(item, id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            itemService.deleteItem(id);
            response.put("message", "Deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
}
