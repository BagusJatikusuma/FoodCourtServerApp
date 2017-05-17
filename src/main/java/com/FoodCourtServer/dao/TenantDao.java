/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Tenant;
import com.FoodCourtServer.model.Card;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author bagus
 */
public interface TenantDao extends Repository<Tenant, Long> {
    public List<Tenant> findAll();

    public Tenant findById(String tenantId);

    @Modifying
    @Query("update Tenant t set t.name = ?2, " +
            "t.openStatus = ?3, " +
            "t.description = ?4, " +
            "t.contact = ?5, " +
            "t.openTime = ?6 " +
            "where t.id = ?1")
    public void updateTenant(String id,
                             String name,
                             Boolean openStatus,
                             String description,
                             String contact,
                             String openTime);
}
