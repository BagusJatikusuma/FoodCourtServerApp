package com.FoodCourtServer.rest;

/**
 * Created by bagus on 25/05/17.
 */
public class MenuOrderWrapper {
    private String menuId;
    private String menuName;
    private Short potion;
    private Integer priceTotal;
    private boolean availability;
    private Integer estimationTime;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Short getPotion() {
        return potion;
    }

    public void setPotion(Short potion) {
        this.potion = potion;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Integer getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(Integer estimationTime) {
        this.estimationTime = estimationTime;
    }
}
