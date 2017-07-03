package com.FoodCourtServer.rest;

import com.FoodCourtServer.model.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
@Component
public class TenantMenuWrapper {

    private String id;

    private String name;

    private Boolean openStatus;

    private String description;

    private String contact;

    private String operationalTime;

    private String image;

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

    public Boolean getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Boolean openStatus) {
        this.openStatus = openStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOperationalTime() {
        return operationalTime;
    }

    public void setOperationalTime(String operationalTime) {
        this.operationalTime = operationalTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
