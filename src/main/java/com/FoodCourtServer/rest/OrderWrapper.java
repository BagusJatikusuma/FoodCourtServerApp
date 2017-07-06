package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.CustomerTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagus on 04/07/17.
 */
public class OrderWrapper {
    private List<MenuOrderWrapper> menuOrderWrappers;
    private boolean orderStatus;
    private CustomerTableWrapper table;
    private Integer paymentTotal;
    private String orderId;

    public List<MenuOrderWrapper> getMenuOrderWrappers() {
        return menuOrderWrappers;
    }

    public void setMenuOrderWrappers(List<MenuOrderWrapper> menuOrderWrappers) {
        this.menuOrderWrappers = menuOrderWrappers;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CustomerTableWrapper getTable() {
        return table;
    }

    public void setTable(CustomerTableWrapper table) {
        this.table = table;
    }

    public Integer getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Integer paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
