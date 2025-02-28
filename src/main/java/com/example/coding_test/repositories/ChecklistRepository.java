package com.example.coding_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.coding_test.entities.Checklist;
import java.util.List;


public interface ChecklistRepository extends JpaRepository<Checklist, Long>{
    
    @Query("select c from Checklist c join c.users u where u.id = :userId and c.isDeleted = false")
    List<Checklist> findAllChecklistUser(Long userId);
}
