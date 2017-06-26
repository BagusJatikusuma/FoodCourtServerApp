/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodCourtServer.service.OrderService;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/transaction")
public class OrderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping("make-payment/")
    public ResponseEntity<?> makePayment() {
        return null;
    }

    @RequestMapping("make-order/")
    public ResponseEntity<?> makeOrder() {
        return null;
    }

}
