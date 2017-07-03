/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Tenant;
import java.util.List;

import org.springframework.data.repository.Repository;

/**
 *
 * @author bagus
 */
public interface TenantDao extends Repository<Tenant, Long> {
    public List<Tenant> findAll();

    public Tenant findById(String tenantId);

    public void save(Tenant tenant);
}
