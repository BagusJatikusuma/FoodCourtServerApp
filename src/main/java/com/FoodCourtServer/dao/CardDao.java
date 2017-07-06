/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Card;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author bagus
 */
public interface CardDao extends Repository<Card, Long> {

    void save(Card card);

    Card findById(String cardId);

    @Query("select c.saldo from Card c where c.id = :id")
    Integer getSaldoById(@Param("id") String cardId);
    
}
