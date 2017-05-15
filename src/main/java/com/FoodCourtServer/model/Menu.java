/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bagus
 */
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    private String id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "Tenant_id")
    private Tenant tenant;
    
    @Column(name = "stock")
    private Integer stock;
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "image_path")
    private String imagePath;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    } 
    
    public String getDescription() {
        return this.description;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public Integer getStock() {
        return this.stock;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getPrice() {
        return this.price;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getImagePath() {
        return this.imagePath;
    }
}
