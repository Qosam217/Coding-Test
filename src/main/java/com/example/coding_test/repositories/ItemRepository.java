package com.example.coding_test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.coding_test.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
    @Query("select i from Item i join i.checklists c where c.id = :checklistId and i.isDeleted = false")
    List<Item> findAllItemByChecklistId(@Param("checklistId") Long id);
}
