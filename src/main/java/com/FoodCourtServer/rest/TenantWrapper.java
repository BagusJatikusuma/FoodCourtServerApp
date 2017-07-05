package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.Topping;

import java.util.List;

/**
 * Created by bagus on 04/07/17.
 */
public class TenantWrapper {

    private String id;

    public TenantWrapper(
            String id,
            String name,
            Boolean openStatus,
            String description,
            String contact,
            String operationalTime,
            String image,
            List<Topping> toppings
    ) {
        this.id = id;
        this.name = name;
        this.openStatus = openStatus;
        this.description = description;
        this.contact = contact;
        this.operationalTime = operationalTime;
        this.image = image;
        this.toppings = toppings;
    }

    private String name;

    private Boolean openStatus;

    private String description;

    private String contact;

    private String operationalTime;

    private String image;

    private List<Topping> toppings;

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

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
