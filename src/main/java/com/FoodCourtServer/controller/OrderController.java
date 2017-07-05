/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Order;
import com.FoodCourtServer.rest.MakeOrderWrapper;
import com.FoodCourtServer.rest.OrderWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.FoodCourtServer.service.OrderService;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping("/make-payment")
    public ResponseEntity<?> makePayment() {
        return null;
    }

    @RequestMapping(value = "/make-order", method = RequestMethod.POST)
    public ResponseEntity<?> makeOrder(@RequestBody MakeOrderWrapper makeOrderWrapper) {
        LOGGER.info("make order");

        MakeOrderWrapper makeOrderWrapperResult = orderService.makeOrder(makeOrderWrapper);

        return new ResponseEntity<>(makeOrderWrapperResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/make-order-test", method = RequestMethod.POST)
    public ResponseEntity<?> makeOrderTest(@RequestBody MakeOrderWrapper makeOrderWrapper) {
        return new ResponseEntity<>(makeOrderWrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/create-test", method = RequestMethod.POST)
    ResponseEntity<?> createOrderTest(@RequestBody Order order) {
        LOGGER.info("create order");

        orderService.create(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
