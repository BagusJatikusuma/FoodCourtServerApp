package com.FoodCourtServer.model;

import javax.persistence.*;

/**
 * Created by bagus on 25/05/17.
 */
@Entity
@Table(name = "TopUp_Transaction")
public class TopUpTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "topup_nominal")
    private Integer topUpNominal;

    @ManyToOne
    @JoinColumn(name = "Card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "Bank_account_id")
    private BankAccount bankAccount;


    public Integer getTopUpNominal() {
        return topUpNominal;
    }

    public void setTopUpNominal(Integer topUpNominal) {
        this.topUpNominal = topUpNominal;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
