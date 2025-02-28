package com.example.coding_test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coding_test.entities.Checklist;
import com.example.coding_test.repositories.ChecklistRepository;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepo;

    public List<Checklist> getAllChecklist(Long id){
        return checklistRepo.findAllChecklistUser(id);
    }

    public Checklist getChecklist(Long id){
        return checklistRepo.findById(id).get();
    }

    public Checklist createChecklist(Checklist checklist){
        return checklistRepo.save(checklist);
    }

    public Checklist updateChecklist(Checklist checklist, Long id){
        Checklist requestChecklist = checklistRepo.findById(id).orElse(null);
        requestChecklist.setTitle(checklist.getTitle());
        return checklistRepo.save(requestChecklist);
    }

    public void deleteChecklist(Long id){
        Checklist checklist = checklistRepo.findById(id).orElse(null);
        checklist.setIsDeleted(true);
        checklistRepo.save(checklist);
    }
    
}
