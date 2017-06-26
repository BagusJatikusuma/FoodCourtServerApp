package com.FoodCourtServer.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by bagus on 26/06/17.
 */
@Embeddable
public class OrderMenuId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "Menu_id")
    private Menu menu;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
