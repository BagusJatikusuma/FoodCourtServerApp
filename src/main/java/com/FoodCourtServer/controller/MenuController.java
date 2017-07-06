/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.rest.MenuWrapper;
import com.FoodCourtServer.service.MenuService;
import com.FoodCourtServer.util.CustomErrorType;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/get-menus", method = RequestMethod.GET)
    public ResponseEntity<?> getMenus() {
        LOGGER.info("fetching menus");

        List<Menu> menus = menuService.getMenus();

        if (menus.isEmpty()) {
            LOGGER.error("menus not found");

            return new ResponseEntity<>(new CustomErrorType("menus not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(menus, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-menus-by-category/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByCategoryId(@PathVariable("idCategory") String idCategory) {
        LOGGER.info("fetching menus with "+idCategory);

        List<Menu> menus = menuService.getMenusByCategory(idCategory);

        if (menus.isEmpty()) {
            LOGGER.error("menus with category id "+idCategory+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-menus-by-tenant/{tenantId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByTenant(@PathVariable("tenantId") String tenantId) {
        LOGGER.info("fetching menus with Tenant "+tenantId);

        List<Menu> menus = menuService.getMenusByTenant(tenantId);

        if (menus.isEmpty()) {
            LOGGER.error("menus with tenant id "+tenantId+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus with tenant "+tenantId+" not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(menus, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-menus-by-tenant-v01/{tenantId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByTenantV01(@PathVariable("tenantId") String tenantId) {
        LOGGER.info("fetching menus with Tenant "+tenantId);

        List<Menu> menus = menuService.getMenusByTenant(tenantId);
        List<MenuWrapper> menuWrappers = new ArrayList<>();

        for (Menu menu : menus) {
            MenuWrapper menuWrapper = new MenuWrapper();

            menuWrapper.setId(menu.getId());
            menuWrapper.setName(menu.getName());
            menuWrapper.setDescription(menu.getDescription());
            menuWrapper.setStock(menu.getStock());
            menuWrapper.setPrice(menu.getPrice());
            menuWrapper.setImage(menu.getImage());
            menuWrapper.setEstimationTime(menu.getEstimationTime());
            menuWrapper.setStockOrdered(menu.getStockOrdered());
            menuWrapper.setMaxLevel(menu.getMaxLevel());
            menuWrapper.setHasLevel(menu.isHasLevel());
            menuWrapper.setCategoryId(menu.getCategory().getId());
            menuWrapper.setCategoryName(menu.getCategory().getName());
            menuWrapper.setHasTopping(!menu.getCategory().getCategoryType());
            menuWrapper.setTenantName(menu.getTenant().getName());

            menuWrappers.add(menuWrapper);
        }

        if (menuWrappers.isEmpty()) {
            LOGGER.error("menus with tenant id "+tenantId+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus with tenant "+tenantId+" not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(menuWrappers, HttpStatus.OK);

    }

    @RequestMapping(value = "/search-menus-by-name/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> searchMenusByName(@PathVariable("name") String name) {
        LOGGER.info("search menu with "+name+" keyword");

        List<Menu> menus = menuService.searchMenusByName(name);

        if (menus.isEmpty()) {
            LOGGER.error("menus with name "+name+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus with name "+name+" not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(menus,HttpStatus.OK);
    }

    @RequestMapping(value = "/test-get-stock/{menuId}", method = RequestMethod.GET)
    ResponseEntity<?> getStock(@PathVariable("menuId") String menuId) {
        LOGGER.info("get "+menuId+" stock");

        Short stock = menuService.getMenuStockById(menuId);

        return new ResponseEntity<Object>(stock, HttpStatus.OK);
    }

}
