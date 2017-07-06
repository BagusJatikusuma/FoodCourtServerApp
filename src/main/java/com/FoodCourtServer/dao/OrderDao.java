/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Order;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 *
 * @author bagus
 */
public interface OrderDao extends Repository<Order, Long> {
    void save(Order order);
    Order findById(String orderId);
//    public void saveTransaction(Transaction transaction);
//    public void update(Transaction transaction);
    
}
