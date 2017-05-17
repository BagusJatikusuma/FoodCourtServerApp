/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.dao.MenuDao;
import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.model.Tenant;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.TenantService;
import com.FoodCourtServer.dao.TenantDao;

/**
 *
 * @author bagus
 */
@Service("TenantService")
@Transactional
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantDao tenantDao;
   
    @Override
    public List<Tenant> getTenants() {
        return tenantDao.findAll();
    }

    @Override
    public Tenant getTenantById(String tenantId) {
        return tenantDao.findById(tenantId);
    }

    @Override
    public void createTenant(Tenant tenant) {
        tenantDao.save(tenant);
    }

    @Override
    public void updateTenant(Tenant tenant) {
        tenantDao.updateTenant(tenant.getId(),
                tenant.getName(),
                tenant.getOpenStatus(),
                tenant.getDescription(),
                tenant.getContact(),
                tenant.getOpenTime());
    }

}
