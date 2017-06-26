/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author bagus
 */
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "payment_status")
    private boolean paymentStatus;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @NotNull
    @Column(name = "payment_total")
    private Integer paymentTotal;

    @NotNull
    @Column(name = "progress_length")
    private Short progressLength;

    @NotNull
    @Column(name = "order_status")
    private boolean orderStatus;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "payment_expired_date")
    private Date paymentExpiredDate;

    @ManyToOne
    @JoinColumn(name = "Card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "Table_id")
    private CustomerTable customerTable;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Integer paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public Short getProgressLength() {
        return progressLength;
    }

    public void setProgressLength(Short progressLength) {
        this.progressLength = progressLength;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPaymentExpiredDate() {
        return paymentExpiredDate;
    }

    public void setPaymentExpiredDate(Date paymentExpiredDate) {
        this.paymentExpiredDate = paymentExpiredDate;
    }
}
