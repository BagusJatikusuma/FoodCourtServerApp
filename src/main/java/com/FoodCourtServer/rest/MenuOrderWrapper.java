package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.Topping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagus on 25/05/17.
 */
public class MenuOrderWrapper {
    private String id;
    private String name;
    private String categoryId;
    private String tenantId;
    private Short portion;
    private Short stock;
    private Short stockOrdered;
    private Short level;
    private String note;
    private Integer priceTotal;
    private boolean availabilityStatus;
    private Integer estimationTime;
    private List<Topping> toppings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getPortion() {
        return portion;
    }

    public void setPortion(Short portion) {
        this.portion = portion;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Integer getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(Integer estimationTime) {
        this.estimationTime = estimationTime;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }

    public Short getStockOrdered() {
        return stockOrdered;
    }

    public void setStockOrdered(Short stockOrdered) {
        this.stockOrdered = stockOrdered;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
