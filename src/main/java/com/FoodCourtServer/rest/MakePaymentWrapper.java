package com.FoodCourtServer.rest;

/**
 * Created by bagus on 06/07/17.
 */
public class MakePaymentWrapper {
    private String cardId;
    private String orderId;
    private Integer paymentTotal;

    public MakePaymentWrapper() {}

    public MakePaymentWrapper(String cardId, String orderId, Integer paymentTotal) {
        this.cardId = cardId;
        this.orderId = orderId;
        this.paymentTotal = paymentTotal;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Integer paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
}
