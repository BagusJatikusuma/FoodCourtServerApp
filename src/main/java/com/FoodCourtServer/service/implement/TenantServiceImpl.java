/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.model.Tenant;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;

import com.FoodCourtServer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.TenantService;
import com.FoodCourtServer.dao.TenantDao;
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
   
    @Override
    public List<Tenant> getTenants() {
        return tenantDao.findAll();
    }

    @Override
    public Tenant getTenantById(String tenantId) {
        return tenantDao.findById(tenantId);
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
