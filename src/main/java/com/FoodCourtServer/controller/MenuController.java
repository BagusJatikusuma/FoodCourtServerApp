/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.service.MenuService;
import com.FoodCourtServer.util.CustomErrorType;

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

    @RequestMapping(value = "/get-menu-by-id/{menuId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenuById(@PathVariable("menuId") String menuId) {
        LOGGER.info("fetching menu with id: "+menuId);

        Menu menu = menuService.getMenuById(menuId);

        if (menu == null) {
            LOGGER.error("menu with id: "+menuId+" not found");

            return new ResponseEntity<>(new CustomErrorType("menu not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(menu, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-menus", method = RequestMethod.GET)
    public ResponseEntity<?> getMenus() {
        LOGGER.info("fetching menus");

        List<Menu> menus = menuService.getMenus();

        if (menus == null) {
            LOGGER.error("menus not found");

            return new ResponseEntity<>(new CustomErrorType("menus not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(menus, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-menus-by-category/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByCategoryId(@PathVariable("idCategory") String idCategory) {
        LOGGER.info("fetching menus with "+idCategory);

        List<Menu> menus = menuService.getMenusByCategory(idCategory);

        if (menus == null) {
            LOGGER.error("menus with "+idCategory+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-menus-by-type/{type}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByCategoryType(@PathVariable("type") Boolean categoryType) {
        LOGGER.info("fetching menus with "+categoryType.toString()+" type");

        List<Menu> menus = menuService.getMenusByCategoryType(categoryType);

        if (menus == null) {
            LOGGER.error("menus with "+categoryType.toString()+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-menus-by-tenant/{tenantId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenusByTenant(@PathVariable("tenantId") String tenantId) {
        LOGGER.info("fetching menus with Tenant "+tenantId);

        List<Menu> menus = menuService.getMenusByTenant(tenantId);

        if (menus == null) {
            LOGGER.error("menus with outlet "+tenantId+" not found");

            return new ResponseEntity<>(new CustomErrorType("menus with tenant "+tenantId+" not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(menus, HttpStatus.OK);

    }

}
