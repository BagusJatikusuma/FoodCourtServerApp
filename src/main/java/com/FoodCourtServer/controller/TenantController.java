/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Tenant;
import com.FoodCourtServer.util.CustomErrorType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.FoodCourtServer.service.TenantService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Autowired
    private TenantService tenantService;

    @RequestMapping(value = "/get-tenants", method = RequestMethod.GET)
    ResponseEntity<?> getTenants() {
        LOGGER.info("fetching Tenants");

        List<Tenant> tenants = tenantService.getTenants();

        if (tenants == null) {
            LOGGER.error("Tenant not found");

            return new ResponseEntity(new CustomErrorType("Tenant not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tenants, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-tenant-by-id/{tenantId}", method = RequestMethod.GET)
    ResponseEntity<?> getTenantById(@PathVariable("tenantId") String tenantId) {
        LOGGER.info("fetch tenant by id : "+tenantId);

        Tenant tenant = tenantService.getTenantById(tenantId);

        if (tenant == null) {
            LOGGER.error("tenant with id: "+tenantId+" not found");

            return new ResponseEntity<>(new CustomErrorType("Tenant not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tenant, HttpStatus.OK);

    }

}
