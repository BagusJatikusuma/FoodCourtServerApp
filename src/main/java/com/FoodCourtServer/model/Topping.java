package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by bagus on 25/06/17.
 */
@Entity
@Table(name = "topping")
public class Topping {
    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "stock")
    private Short stock;

    @NotNull
    @Column(name = "stock_ordered")
    private Short stockOrdered;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "Tenant_id")
    private Tenant tenant;

    public Topping(){}

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
