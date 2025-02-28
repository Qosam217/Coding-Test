package com.example.coding_test.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity{

    @Column(name = "detail")
    private String detail;

    @Column(name = "checked", columnDefinition = "boolean default false")
    private boolean checked;

    @OneToMany(mappedBy = "item")
    @JsonManagedReference
    private List<Checklist> checklists;
    
}
