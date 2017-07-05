/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.controller.OrderController;
import com.FoodCourtServer.dao.OrderMenuDao;
import com.FoodCourtServer.dao.OrderMenuToppingDao;
import com.FoodCourtServer.model.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.FoodCourtServer.rest.*;
import com.FoodCourtServer.service.MenuService;
import com.FoodCourtServer.service.ToppingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.OrderService;
import com.FoodCourtServer.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bagus
 */
@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired private OrderDao orderDao;
    @Autowired private OrderMenuDao orderMenuDao;
    @Autowired private OrderMenuToppingDao orderMenuToppingDao;

    @Autowired private MenuService menuService;
    @Autowired private ToppingService toppingService;
    
    @Override
    public void createTransaction(List<Menu> Menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTransaction(Order transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
//    @Transactional(readOnly = true)
    public MakeOrderWrapper makeOrder(MakeOrderWrapper makeOrderWrapper) {
        boolean isStockUnAvailable = false;
        // compare menu and topping portion with stock
        // compare menu portion
        short stock = 0;
        for (MenuCompared menuCompared : makeOrderWrapper.getItemCompared().getMenuCompared()) {
            stock = menuService.getMenuStockById(menuCompared.getMenuId());
            menuCompared.setStock(stock);

            if (stock >= menuCompared.getPortion()) {
                menuCompared.setStatusAvailability(true);
            } else {
                isStockUnAvailable = true;
            }
        }
        // compare topping portion
        for (ToppingCompared toppingCompared : makeOrderWrapper.getItemCompared().getToppingCompared()) {
            stock = toppingService.getStockById(toppingCompared.getToppingId());
            toppingCompared.setStock(stock);

            if (stock >= toppingCompared.getPortion()) {
                toppingCompared.setStatusAvailability(true);
            } else {
                isStockUnAvailable = true;
            }
        }

        if (!isStockUnAvailable) {
            //save order to order table
            LOGGER.info("save transaction");

            OrderWrapper orderWrapper = makeOrderWrapper.getOrderWrapper();
            ItemCompared itemCompared = makeOrderWrapper.getItemCompared();

            Order order = new Order(
                    orderWrapper.getOrderId(),
                    false,
                    new Date(),
                    orderWrapper.getPaymentTotal(),
                    (short) 0,
                    false,
                    new Date(),
                    null,
                    orderWrapper.getTable()
            );

            orderDao.save(order);
//            //save OrderMenu to OrderMenu Table
//            for (MenuOrderWrapper menuOrderWrapper : orderWrapper.getMenuOrderWrappers()) {
//                OrderMenu orderMenu = new OrderMenu(
//                        new OrderMenuId(
//                                order,
//                                menuService.getMenuById(menuOrderWrapper.getId())
//                                ),
//                        menuOrderWrapper.getPortion(),
//                        menuOrderWrapper.getPriceTotal(),
//                        false,
//                        menuOrderWrapper.getNote(),
//                        menuOrderWrapper.getLevel()
//                );
//
//                orderMenuDao.save(orderMenu);
//
//                //save OrderMenuTopping to OrderMenuTopping Table
//                for (Topping topping : menuOrderWrapper.getToppings()) {
//                    for (ToppingCompared toppingCompared : itemCompared.getToppingCompared()) {
//                        if (topping.getId() == toppingCompared.getToppingId()) {
//                                OrderMenuTopping orderMenuTopping = new OrderMenuTopping(
//                                        new OrderMenuToppingId(
//                                                topping,
//                                                orderMenu
//                                        ),
//                                        toppingCompared.getPortion(),
//                                        topping.getPrice()
//                                );
//
//                                orderMenuToppingDao.save(orderMenuTopping);
//
//                        }
//
//                    }
//
//                }
//
//            }

        }

        return makeOrderWrapper;
    }

    @Override
    public void create(Order order) {
        orderDao.save(order);
    }

}
