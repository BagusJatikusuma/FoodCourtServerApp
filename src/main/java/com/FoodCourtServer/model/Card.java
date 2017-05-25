/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author bagus
 */
@Entity
@Table(name = "Card")
public class Card {

    @Id
    private String id;

    @NotNull
    @Column(name = "saldo")
    private Integer saldo;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<OrderTransaction> orderTransactions;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    
}
