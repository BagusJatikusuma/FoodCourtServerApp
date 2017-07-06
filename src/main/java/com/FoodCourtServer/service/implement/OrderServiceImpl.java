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
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

import com.FoodCourtServer.rest.*;
import com.FoodCourtServer.service.CardService;
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
    @Autowired private CardService cardService;
    
    @Override
    public void createTransaction(List<Menu> Menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTransaction(Order transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
                    new CustomerTable(
                            orderWrapper.getTable().getId(),
                            Character.toString(orderWrapper.getTable().getSector()),
                            orderWrapper.getTable().getTableTotal()
                    )
            );

            orderDao.save(order);
            orderWrapper.setOrderStatus(true);
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
    public int makePayment(MakePaymentWrapper makePaymentWrapper) {
        LOGGER.info("make payment service");

        Integer customerSaldo = cardService.getSaldo(makePaymentWrapper.getCardId());
        Integer paymentTotal = makePaymentWrapper.getPaymentTotal();

        if (customerSaldo == null) return 0;

        if (customerSaldo < paymentTotal) return -1;
        else {
            cardService.editCardSaldo(customerSaldo - paymentTotal, makePaymentWrapper.getCardId());
            changePaymentStatusByOrderId(makePaymentWrapper.getOrderId());
        }

        return 1;
    }

    public void changePaymentStatusByOrderId(String orderId) {
        LOGGER.info("change payment status "+orderId);

        Order order = orderDao.findById(orderId);

        order.setPaymentStatus(true);

    }

    @Override
    public void create(Order order) {
        orderDao.save(order);
    }

    @Override
    public void createOrderMenuByOrder(MakeOrderWrapper makeOrderWrapper) {
        LOGGER.info("save orderMenu");

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
                new CustomerTable(
                        orderWrapper.getTable().getId(),
                        Character.toString(orderWrapper.getTable().getSector()),
                        orderWrapper.getTable().getTableTotal()
                )
        );

        //save OrderMenu to OrderMenu Table
        for (MenuOrderWrapper menuOrderWrapper : orderWrapper.getMenuOrderWrappers()) {
            for (MenuCompared menuCompared : itemCompared.getMenuCompared()) {
                if (menuOrderWrapper.getId().equals(menuCompared.getMenuId())) {
                    OrderMenu orderMenu = new OrderMenu(
                            new OrderMenuId(
                                    order,
                                    menuService.getMenuById(menuOrderWrapper.getId())
                            ),
                            menuCompared.getPortion(),
                            menuOrderWrapper.getPriceTotal(),
                            false,
                            menuOrderWrapper.getNote(),
                            menuOrderWrapper.getLevel()
                    );

                    orderMenuDao.save(orderMenu);
                }
            }
        }
//            //save OrderMenuTopping to OrderMenuTopping Table
//            for (Topping topping : menuOrderWrapper.getToppings()) {
//                for (ToppingCompared toppingCompared : itemCompared.getToppingCompared()) {
//                    if (topping.getId() == toppingCompared.getToppingId()) {
//                            OrderMenuTopping orderMenuTopping = new OrderMenuTopping(
//                                    new OrderMenuToppingId(
//                                            topping,
//                                            orderMenu
//                                    ),
//                                    toppingCompared.getPortion(),
//                                    topping.getPrice()
//                            );
//
//                            orderMenuToppingDao.save(orderMenuTopping);
//
//                    }
//
//                }
//
//            }

//        }

    }

    @Override
    public void createOrderMenuToppingByOrder(MakeOrderWrapper makeOrderWrapper) {
        LOGGER.info("save orderMenuTopping");

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
                new CustomerTable(
                        orderWrapper.getTable().getId(),
                        Character.toString(orderWrapper.getTable().getSector()),
                        orderWrapper.getTable().getTableTotal()
                )
        );

        //save OrderMenu to OrderMenu Table
        for (MenuOrderWrapper menuOrderWrapper : orderWrapper.getMenuOrderWrappers()) {
            OrderMenu orderMenu = new OrderMenu(
                    new OrderMenuId(
                            order,
                            menuService.getMenuById(menuOrderWrapper.getId())
                    ),
                    menuOrderWrapper.getPortion(),
                    menuOrderWrapper.getPriceTotal(),
                    false,
                    menuOrderWrapper.getNote(),
                    menuOrderWrapper.getLevel()
            );


            //save OrderMenuTopping to OrderMenuTopping Table
            for (Topping topping : menuOrderWrapper.getToppings()) {
                for (ToppingCompared toppingCompared : itemCompared.getToppingCompared()) {
                    if (topping.getId().equals(toppingCompared.getToppingId())) {
                        OrderMenuTopping orderMenuTopping = new OrderMenuTopping(
                                new OrderMenuToppingId(
                                        topping,
                                        orderMenu
                                ),
                                toppingCompared.getPortion(),
                                topping.getPrice()
                        );

                        orderMenuToppingDao.save(orderMenuTopping);

                    }

                }

            }

        }

    }

    @Override
    public MakeOrderWrapper commitMakeOrder(MakeOrderWrapper makeOrderWrapper) {
        MakeOrderWrapper makeOrderWrapperResult = makeOrder(makeOrderWrapper);

        if (makeOrderWrapper.getOrderWrapper().isOrderStatus()) {
            createOrderMenuByOrder(makeOrderWrapperResult);
        }

        return makeOrderWrapperResult;

    }

    @Override
    public void editStockByOrder(MakeOrderWrapper makeOrderWrapper) {
        LOGGER.info("edit stock By Order");

        OrderWrapper orderWrapper = makeOrderWrapper.getOrderWrapper();
        ItemCompared itemCompared = makeOrderWrapper.getItemCompared();

        for (MenuCompared menuCompared : itemCompared.getMenuCompared()) {
            Menu menu = menuService.getMenuById(menuCompared.getMenuId());

            menu.setStock((short)(menu.getStock().shortValue() - menuCompared.getPortion()));
            menu.setStockOrdered((short)(menu.getStockOrdered()+menuCompared.getPortion()));

            menuService.update(menu);

        }

        for (ToppingCompared toppingCompared : itemCompared.getToppingCompared()) {
            Topping topping = toppingService.getToppingById(toppingCompared.getToppingId());

            topping.setStock((short)(topping.getStock().shortValue() - toppingCompared.getPortion()));
            topping.setStockOrdered((short)(topping.getStockOrdered()+toppingCompared.getPortion()));

            toppingService.update(topping);

        }

    }

}
