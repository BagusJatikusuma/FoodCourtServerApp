package com.FoodCourtServer.rest;

import java.util.Date;

/**
 * Created by bagus on 25/05/17.
 */
public class TopUpTransactionWrapper {
    private String transactionId;
    private String cardId;
    private Integer topUpNominal;
    private String bankAccountId;
    private Date topUpDate;
    private short transactionStatus;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getTopUpNominal() {
        return topUpNominal;
    }

    public void setTopUpNominal(Integer topUpNominal) {
        this.topUpNominal = topUpNominal;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getTopUpDate() {
        return topUpDate;
    }

    public void setTopUpDate(Date topUpDate) {
        this.topUpDate = topUpDate;
    }

    public short getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(short transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
