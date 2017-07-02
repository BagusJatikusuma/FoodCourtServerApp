/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Tenant;
import com.FoodCourtServer.util.CustomErrorType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FoodCourtServer.service.TenantService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.xml.ws.Response;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Autowired
    private TenantService tenantService;

    @RequestMapping(value = "/get-tenants", method = RequestMethod.GET)
    ResponseEntity<?> getTenants() {
        LOGGER.info("fetching Tenants");

        List<Tenant> tenants = tenantService.getTenants();

        if (tenants.isEmpty()) {
            LOGGER.error("Tenant not found");

            return new ResponseEntity<>(new CustomErrorType("Tenant not found"), HttpStatus.NOT_FOUND);
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

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    ResponseEntity<?> editTenant(
            @RequestPart("metadata") Tenant tenant,
            @RequestPart("file") MultipartFile imageFile) {
        LOGGER.info("edit "+tenant.toString());

        try {
            tenantService.updateTenant(tenant, imageFile);
        } catch (IOException e) {
            LOGGER.error("cannot read the image");

            return new ResponseEntity<>(
                    new CustomErrorType("cannot read the image"),
                    HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(tenant,HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<?> createTenant(
            @RequestPart("metadata") Tenant tenant,
            @RequestPart("file") MultipartFile imageFile) {
        LOGGER.info("create "+tenant.toString());

        try {
            tenantService.createTenant(tenant, imageFile);
        } catch (IOException e) {
            LOGGER.error("cannot read the image");

            return new ResponseEntity<>(
                    new CustomErrorType("cannot read the image"),
                    HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(tenant, HttpStatus.CREATED);
    }

}
