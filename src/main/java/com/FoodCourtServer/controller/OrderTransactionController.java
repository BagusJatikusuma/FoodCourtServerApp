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

import com.FoodCourtServer.service.OrderTransactionService;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderTransactionController.class);

    @Autowired
    OrderTransactionService transactionService;

    @RequestMapping("make-payment/")
    public ResponseEntity<?> makePayment() {
        return null;
    }

    @RequestMapping("make-order/")
    public ResponseEntity<?> makeOrder() {
        return null;
    }

}
