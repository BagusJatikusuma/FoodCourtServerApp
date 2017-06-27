package com.FoodCourtServer.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by bagus on 26/06/17.
 */
//@Embeddable
public class OrderMenuId implements Serializable {
//    @JoinColumn(name = "Order_id")
//    private String orderId;
//
//    @JoinColumn(name = "Menu_id")
//    private String menuId;
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getMenuId() {
//        return menuId;
//    }
//
//    public void setMenuId(String menuId) {
//        this.menuId = menuId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof OrderMenuId)) return false;
//        OrderMenuId that = (OrderMenuId) o;
//        return Objects.equals(getOrderId(), that.getOrderId()) &&
//                Objects.equals(getMenuId(), that.getMenuId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getOrderId(), getMenuId());
//    }
}
