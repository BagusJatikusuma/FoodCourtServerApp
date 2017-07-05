package com.FoodCourtServer.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagus on 04/07/17.
 */
public class ItemCompared {
    private List<MenuCompared> menuCompared;
    private List<ToppingCompared> toppingCompared;

    public List<MenuCompared> getMenuCompared() {
        return menuCompared;
    }

    public void setMenuCompared(List<MenuCompared> menuCompared) {
        this.menuCompared = menuCompared;
    }

    public List<ToppingCompared> getToppingCompared() {
        return toppingCompared;
    }

    public void setToppingCompared(List<ToppingCompared> toppingCompared) {
        this.toppingCompared = toppingCompared;
    }
}
