package com.FoodCourtServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by bagus on 25/06/17.
 */
@Entity
@Table(name = "topping")
public class Topping {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Short stock;

    @Column(name = "stock_ordered")
    private Short stockOrdered;

    @Column(name = "price")
    private Integer price;

    public Topping(String id, String name, Short stock, Short stockOrdered, Integer price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.stockOrdered = stockOrdered;
        this.price = price;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
