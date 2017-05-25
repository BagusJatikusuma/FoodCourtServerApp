package com.FoodCourtServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by bagus on 25/05/17.
 */
@Entity
@Table(name = "BankAccount")
public class BankAccount {
    @Id
    private String id;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "bank_name")
    private String bankName;


    public BankAccount(String id, String ownerName, String bankName) {
        this.id = id;
        this.ownerName = ownerName;
        this.bankName = bankName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
