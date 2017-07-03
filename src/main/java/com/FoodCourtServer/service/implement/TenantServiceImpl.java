/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.model.Tenant;

import java.io.IOException;
import java.util.List;

import com.FoodCourtServer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.TenantService;
import com.FoodCourtServer.dao.TenantDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bagus
 */
@Service("TenantService")
@Transactional
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantDao tenantDao;

    @Autowired
    private ImageService imageService;

    private final String TENANT_IMAGE_URL = "http://192.168.100.31:8080/images/get-tenant-image/";
   
    @Override
    @Transactional(readOnly = true)
    public List<Tenant> getTenants() {
        List<Tenant> tenants = tenantDao.findAll();

        for (Tenant tenant : tenants) {
            tenant.setImage(TENANT_IMAGE_URL+tenant.getImage());
        }

        return tenants;
    }

    @Override
    @Transactional(readOnly = true)
    public Tenant getTenantById(String tenantId) {
        Tenant tenant = tenantDao.findById(tenantId);
        tenant.setImage(TENANT_IMAGE_URL+tenant.getImage());

        return tenant;
    }

    @Override
    public void createTenant(Tenant tenant, MultipartFile imageFile) throws IOException {
        tenant.setImage(tenant.getId());

        imageService.uploadImage(imageFile,"tenant", tenant.getId());

        tenantDao.save(tenant);
    }

    @Override
    public void updateTenant(Tenant tenant, MultipartFile imageFile) throws IOException {
        tenant.setImage(tenant.getId());

        imageService.uploadImage(imageFile,"tenant", tenant.getId());

        tenantDao.save(tenant);
    }

}
