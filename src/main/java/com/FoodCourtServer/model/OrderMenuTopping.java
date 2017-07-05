package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by bagus on 26/06/17.
 */
@Entity
@Table(name = "OrderMenuTopping")
public class OrderMenuTopping {
    @EmbeddedId
    private OrderMenuToppingId orderMenuToppingId;

    @NotNull
    @Column(name = "portion")
    private Short portion;

    @NotNull
    @Column(name = "price")
    private Integer price;

    public OrderMenuTopping() {}

    public OrderMenuTopping(
            OrderMenuToppingId orderMenuToppingId,
            Short portion,
            Integer price)
    {
        this.orderMenuToppingId = orderMenuToppingId;
        this.portion = portion;
        this.price = price;
    }

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
