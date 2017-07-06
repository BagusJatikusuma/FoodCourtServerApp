/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.model.Card;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
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
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired private CardDao cardDao;

    @Override
    public Integer getSaldo(String cardId) {
        return cardDao.getSaldoById(cardId);
    }

    @Override
    public void update(Card card) {
        LOGGER.info("update card");

        cardDao.save(card);
    }

    @Override
    public void editCardSaldo(Integer newSaldo, String cardId) {
        LOGGER.info("edit card saldo");

        Card card = cardDao.findById(cardId);

        card.setSaldo(newSaldo);
    }

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
