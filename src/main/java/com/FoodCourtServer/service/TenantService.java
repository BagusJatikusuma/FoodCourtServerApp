/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.model.Tenant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author bagus
 */
public interface TenantService {
    public List<Tenant> getTenants();
    public Tenant getTenantById(String tenantId);
    public void createTenant(Tenant tenant, MultipartFile imageFile) throws IOException;
    public void updateTenant(Tenant tenant, MultipartFile imageFile) throws IOException;
}
