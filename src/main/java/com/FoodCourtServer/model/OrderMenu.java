package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by bagus on 26/06/17.
 */
@Entity(name = "OrderMenu")
@Table(name = "OrderMenu")
public class OrderMenu {
    @EmbeddedId
    private OrderMenuId orderMenuId;

    @NotNull
    @Column(name = "protion")
    private Short portion;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "order_status")
    private boolean orderStatus;

    @Column(name = "note")
    private String note;

    @Column(name = "level")
    private Short level;

    public Short getPortion() {
        return portion;
    }

    public void setPortion(Short portion) {
        this.portion = portion;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }
}
