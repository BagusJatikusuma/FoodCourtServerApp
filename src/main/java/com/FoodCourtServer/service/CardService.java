/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Card;

/**
 *
 * @author bagus
 */
public interface CardService {
//    public Customer getUserByEmail(String email);
    Integer getSaldo(String idCard);
    void update(Card card);
    void editCardSaldo(Integer newSaldo, String cardId);
    
}
