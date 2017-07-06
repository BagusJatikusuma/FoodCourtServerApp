package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.Order;

import java.util.List;

/**
 * Created by bagus on 05/07/17.
 */
public class CustomerTableWrapper {

    private String id;

    private char sector;

    private Short tableTotal;

    private List<Order> orders;

    public CustomerTableWrapper() {}

    public CustomerTableWrapper(String id, char sector, Short tableTotal) {
        this.id = id;
        this.sector = sector;
        this.tableTotal = tableTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getTableTotal() {
        return tableTotal;
    }

    public void setTableTotal(Short tableTotal) {
        this.tableTotal = tableTotal;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }
}
