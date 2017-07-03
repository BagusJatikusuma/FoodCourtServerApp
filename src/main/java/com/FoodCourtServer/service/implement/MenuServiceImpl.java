/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.controller.MenuController;
import com.FoodCourtServer.dao.MenuDao;
import com.FoodCourtServer.model.Category;
import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.rest.MenuWrapper;
import com.FoodCourtServer.rest.TenantMenuWrapper;
import com.FoodCourtServer.service.CategoryService;
import com.FoodCourtServer.service.ImageService;
import com.FoodCourtServer.service.MenuService;

import java.util.ArrayList;
import java.util.List;

import com.FoodCourtServer.service.TenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bagus
 */
@Service("MenuService")
@Transactional
public class MenuServiceImpl implements MenuService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private ImageService imageService;

    private final String MENU_IMAGE_URL = "http://192.168.100.31:8080/images/get-menu-image/";
    
    @Override
    public Menu getMenuById(String menuId) {
        return menuDao.findById(menuId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenusByTenant(String tenantId) {
        List<Menu> menus = menuDao.findByTenant_Id(tenantId);

        for (Menu menu : menus) {
            menu.setImage(MENU_IMAGE_URL+menu.getImage());
        }

        return menus;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuWrapper> getMenusByTenantV01(String tenantId) {

        LOGGER.info("get menus service");

        List<Menu> menus = menuDao.findByTenant_Id(tenantId);
        List<MenuWrapper> menuWrappers = new ArrayList<>();

//        for (Menu menu : menus) {
//            menu.setImage(MENU_IMAGE_URL+menu.getImage());
//
//            for (MenuWrapper menuWrapper : menuWrappers) {
//                menuWrapper.setId(menu.getId());
//                menuWrapper.setName(menu.getName());
//                menuWrapper.setDescription(menu.getDescription());
//                menuWrapper.setStock(menu.getStock());
//                menuWrapper.setPrice(menu.getPrice());
//                menuWrapper.setImage(menu.getImage());
//                menuWrapper.setEstimationTime(menu.getEstimationTime());
//                menuWrapper.setStockOrdered(menu.getStockOrdered());
//                menuWrapper.setMaxLevel(menu.getMaxLevel());
//                menuWrapper.setHasLevel(menu.isHasLevel());
//                menuWrapper.setCategoryId(menu.getCategory().getId());
//                menuWrapper.setCategoryName(menu.getCategory().getName());
//            }
//        }

        return menuWrappers;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenusByCategory(String categoryId) {
        List<Menu> menus = menuDao.findByCategory_Id(categoryId);

        for (Menu menu : menus) {
            menu.setImage(MENU_IMAGE_URL+menu.getImage());
        }

        return menus;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> searchMenusByName(String name) {
        List<Menu> menus = menuDao.findByNameContaining(name);

        for (Menu menu : menus) {
            menu.setImage(MENU_IMAGE_URL+menu.getImage());
        }

        return menus;

    }

    @Override
    public Integer getMenuStockById(String menuId) {
        return menuDao.getMenuStockById(menuId);
    }

    @Override
    @Transactional(readOnly = true)
    public void orderMenu(List<Menu> menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenusByCategoryType(Boolean categoryType) {
        return menuDao.findByCategory_CategoryType(categoryType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenus() {
        List<Menu> menus = menuDao.findAll();

        for (Menu menu : menus) {
            menu.setImage(MENU_IMAGE_URL+menu.getImage());
        }

        return menus;
    }
    
}
