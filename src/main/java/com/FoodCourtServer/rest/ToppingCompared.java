package com.FoodCourtServer.rest;

/**
 * Created by bagus on 04/07/17.
 */
public class ToppingCompared {
    private String toppingId;
    private short portion;
    private short stock;
    private boolean statusAvailability;

    public String getToppingId() {
        return toppingId;
    }

    public void setToppingId(String toppingId) {
        this.toppingId = toppingId;
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

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }
}
