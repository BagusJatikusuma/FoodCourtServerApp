package com.FoodCourtServer.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by bagus on 26/06/17.
 */
//@Embeddable
public class OrderMenuToppingId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Topping_id")
    private Topping topping;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "Order_menuOrder_id",
                    referencedColumnName = "Order_id"
            ),
            @JoinColumn(
                    name = "Order_menuMenu_id",
                    referencedColumnName = "Menu_id"
            )
    })
    private OrderMenu orderMenu;

    public OrderMenuToppingId() {}

    public OrderMenuToppingId(Topping topping, OrderMenu orderMenu) {
        this.topping = topping;
        this.orderMenu = orderMenu;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public OrderMenu getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
    }
}
