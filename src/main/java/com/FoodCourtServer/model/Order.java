/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author bagus
 */
@Entity
@CustomerTable(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "pay_status")
    private Boolean paySTatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "payment_total")
    private Integer paymentTotal;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "progress_total")
    private Integer progressTotal;

    @ManyToOne
    @JoinColumn(name = "Card_id")
    private Card card;

    public Order(Boolean paySTatus, Date orderDate, Integer paymentTotal, Integer tableNumber, Integer progressTotal) {
        this.paySTatus = paySTatus;
        this.orderDate = orderDate;
        this.paymentTotal = paymentTotal;
        this.tableNumber = tableNumber;
        this.progressTotal = progressTotal;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPaySTatus() {
        return paySTatus;
    }

    public void setPaySTatus(Boolean paySTatus) {
        this.paySTatus = paySTatus;
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

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getProgressTotal() {
        return progressTotal;
    }

    public void setProgressTotal(Integer progressTotal) {
        this.progressTotal = progressTotal;
    }
}
