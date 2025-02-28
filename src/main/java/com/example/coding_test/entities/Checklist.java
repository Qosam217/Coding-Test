package com.example.coding_test.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Checklists")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checklist extends BaseEntity{

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    @JsonBackReference
    private Item item;

    @Column(name = "item_id")
    private Long itemId;

    @OneToMany(mappedBy = "checklist")
    @JsonManagedReference
    private List<User> users;

    
}
