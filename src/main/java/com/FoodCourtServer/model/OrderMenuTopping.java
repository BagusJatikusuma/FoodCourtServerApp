package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by bagus on 26/06/17.
 */
@Entity
@Table(name = "OrderMenuTopping")
public class OrderMenuTopping {
    @Id
    private int id;

    @NotNull
    @Column(name = "portion")
    private Short portion;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "Topping_id")
    private Topping topping;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Short getPortion() {
        return portion;
    }

    public void setPortion(Short portion) {
        this.portion = portion;
    }
}
