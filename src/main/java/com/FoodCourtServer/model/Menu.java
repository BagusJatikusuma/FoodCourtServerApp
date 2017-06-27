/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author bagus
 */
@Entity(name = "Menu")
@Table(name = "Menu")
public class Menu {
    @Id
    @Column(name = "id")
    private String id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "stock")
    private Short stock;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "estimation_time")
    private Short estimationTime;

    @NotNull
    @Column(name = "stock_ordered")
    private Short stockOrdered;

    @Column(name = "max_level")
    private Short maxLevel;

    @NotNull
    @Column(name = "has_level")
    private boolean hasLevel;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Tenant_id")
    private Tenant tenant;
    
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
    
    public void setStock(Short stock) {
        this.stock = stock;
    }
    
    public Short getStock() {
        return this.stock;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getPrice() {
        return this.price;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getImage() {
        return this.image;
    }

    public Short getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(Short estimationTime) {
        this.estimationTime = estimationTime;
    }

    public Short getStockOrdered() {
        return stockOrdered;
    }

    public void setStockOrdered(Short stockOrdered) {
        this.stockOrdered = stockOrdered;
    }

    public Short getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Short maxLevel) {
        this.maxLevel = maxLevel;
    }

    public boolean isHasLevel() {
        return hasLevel;
    }

    public void setHasLevel(boolean hasLevel) {
        this.hasLevel = hasLevel;
    }
}
