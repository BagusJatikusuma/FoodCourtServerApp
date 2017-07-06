/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.model.Order;
import com.FoodCourtServer.rest.MakeOrderWrapper;
import com.FoodCourtServer.rest.MakePaymentWrapper;

import java.util.List;

/**
 *
 * @author bagus
 */
public interface OrderService {
    void createTransaction(List<Menu> Menus);
    void updateTransaction(Order transaction);

    MakeOrderWrapper makeOrder(MakeOrderWrapper makeOrderWrapper);
    int makePayment(MakePaymentWrapper makePaymentWrapper);

    //for testing
    void create(Order order);

    //need revision
    void createOrderMenuByOrder(MakeOrderWrapper makeOrderWrapper);
    //need revision
    void createOrderMenuToppingByOrder(MakeOrderWrapper makeOrderWrapper);
    //need revision
    MakeOrderWrapper commitMakeOrder(MakeOrderWrapper makeOrderWrapper);
    //need revision
    void editStockByOrder(MakeOrderWrapper makeOrderWrapper);
}
