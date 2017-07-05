package com.FoodCourtServer.rest;

/**
 * Created by bagus on 04/07/17.
 */
public class MenuCompared {
    private String menuId;
    private short portion;
    private Short stock;
    private boolean statusAvailability;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public short getPortion() {
        return portion;
    }

    public void setPortion(short portion) {
        this.portion = portion;
    }

    public boolean isStatusAvailability() {
        return statusAvailability;
    }

    public void setStatusAvailability(boolean statusAvailability) {
        this.statusAvailability = statusAvailability;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }
}
