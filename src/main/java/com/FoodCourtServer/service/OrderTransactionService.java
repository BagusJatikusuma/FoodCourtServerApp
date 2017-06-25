/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.model.Order;
import java.util.List;

/**
 *
 * @author bagus
 */
public interface OrderTransactionService {
    public void createTransaction(List<Menu> Menus);
    public void updateTransaction(Order transaction);
    
}
