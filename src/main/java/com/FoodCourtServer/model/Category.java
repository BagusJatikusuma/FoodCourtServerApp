/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bagus
 */
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name="id")
    private String id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Menu> menus;
    
    @NotNull
    @Column(name = "tipe_kategori")
    private Boolean categoryType;

    public Category() {}

    public Category(String id, String name, Boolean categoryType) {
        this.id = id;
        this.name = name;
        this.categoryType = categoryType;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setcategoryType(Boolean categoryType) {
        this.categoryType = categoryType;
    }
    
    public Boolean getCategoryType() {
        return this.categoryType;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
