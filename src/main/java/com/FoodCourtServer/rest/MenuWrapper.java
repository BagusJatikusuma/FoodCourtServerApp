package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
@Component
public class MenuWrapper {
    private String id;

    private String name;

    private String description;

    private Short stock;

    private Integer price;

    private String image;

    private Short estimationTime;

    private Short stockOrdered;

    private Short maxLevel;

    private boolean hasLevel;

    private String categoryId;

    private String categoryName;

    private boolean hasTopping;

    private String tenantName;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isHasTopping() {
        return hasTopping;
    }

    public void setHasTopping(boolean hasTopping) {
        this.hasTopping = hasTopping;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
