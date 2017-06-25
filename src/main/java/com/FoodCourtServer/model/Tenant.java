/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bagus
 */
@Entity
@CustomerTable(name = "Tenant")
public class Tenant {
    
    @Id
    private String id;
    
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "open_status")
    private Boolean openStatus;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "contact")
    private String contact;

    @NotNull
    @Column(name = "operational_time")
    private String operationalTime;

    @NotNull
    @Column(name = "image")
    private String image;
    
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Menu> menus;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getOperationalTime() {
        return operationalTime;
    }

    public void setOperationalTime(String operationalTime) {
        this.operationalTime = operationalTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Boolean openStatus) {
        this.openStatus = openStatus;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
