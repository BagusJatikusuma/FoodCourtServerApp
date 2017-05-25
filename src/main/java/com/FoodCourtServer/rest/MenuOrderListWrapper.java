package com.FoodCourtServer.rest;

import java.util.List;

/**
 * Created by bagus on 25/05/17.
 */
public class MenuOrderListWrapper {
    private List<MenuOrderWrapper> menuOrderWrappers;
    private Integer priceTotal;

    public List<MenuOrderWrapper> getMenuOrderWrappers() {
        return menuOrderWrappers;
    }

    public void setMenuOrderWrappers(List<MenuOrderWrapper> menuOrderWrappers) {
        this.menuOrderWrappers = menuOrderWrappers;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }
}
