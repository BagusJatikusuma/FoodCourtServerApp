package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.OrderMenu;
import org.springframework.data.repository.Repository;

/**
 * Created by bagus on 05/07/17.
 */
public interface OrderMenuDao extends Repository<OrderMenu, Long> {
    public void save(OrderMenu orderMenu);
}
