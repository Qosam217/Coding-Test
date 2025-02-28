package com.example.coding_test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coding_test.dtos.ChecklistDto;
import com.example.coding_test.entities.Checklist;
import com.example.coding_test.services.ChecklistService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


  


@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getAllChecklist(@PathVariable("userId") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", checklistService.getAllChecklist(null));
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getChecklist(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", checklistService.getChecklist(null));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveChecklist(@RequestBody ChecklistDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Checklist checklist = new Checklist();
            checklist.setTitle(dto.getTitle());
            response.put("data", checklistService.createChecklist(checklist));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateChecklist(@PathVariable("id") Long id, @RequestBody ChecklistDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Checklist checklist = new Checklist();
            checklist.setTitle(dto.getTitle());
            response.put("data", checklistService.updateChecklist(checklist, id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteChecklist(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            checklistService.deleteChecklist(id);
            response.put("data", "Success delete checklist");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
    

}
