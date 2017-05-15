/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.model.Card;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.CardService;
import com.FoodCourtServer.dao.CardDao;

/**
 *
 * @author bagus
 */
@Service("CardService")
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao customerDao;
    
//    @Override
//    public Customer getUserByEmail(String email) {
//        return customerDao.findByEmail(email);
//    }
//
//    @Override
//    public Integer getCustomerSaldo(String idCard) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
