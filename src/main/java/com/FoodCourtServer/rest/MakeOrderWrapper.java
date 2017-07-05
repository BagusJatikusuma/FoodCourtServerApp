package com.FoodCourtServer.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagus on 04/07/17.
 */
public class MakeOrderWrapper {
    private ItemCompared itemCompared;
    private OrderWrapper orderWrapper;

    public ItemCompared getItemCompared() {
        return itemCompared;
    }

    public void setItemCompared(ItemCompared itemCompared) {
        this.itemCompared = itemCompared;
    }

    public OrderWrapper getOrderWrapper() {
        return orderWrapper;
    }

    public void setOrderWrapper(OrderWrapper orderWrapper) {
        this.orderWrapper = orderWrapper;
    }
}
