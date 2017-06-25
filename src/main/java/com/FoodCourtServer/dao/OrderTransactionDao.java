/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Order;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bagus
 */
public interface OrderTransactionDao extends CrudRepository<Order, Serializable>{
//    public void saveTransaction(Transaction transaction);
//    public void update(Transaction transaction);
    
}
