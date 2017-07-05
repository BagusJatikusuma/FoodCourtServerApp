package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.OrderMenuTopping;
import org.springframework.data.repository.Repository;

/**
 * Created by bagus on 05/07/17.
 */
public interface OrderMenuToppingDao extends Repository<OrderMenuTopping, Long>{
    public void save(OrderMenuTopping orderMenuTopping);
}
