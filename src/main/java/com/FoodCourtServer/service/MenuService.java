/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.rest.MenuWrapper;

import java.util.List;

/**
 *
 * @author bagus
 */
public interface MenuService {
    public Menu getMenuById(String menuId);
    public List<Menu> getMenus();
    public List<Menu> getMenusByTenant(String tenantId);
    public List<Menu> getMenusByCategory(String categoryId);
    public List<Menu> getMenusByCategoryType(Boolean categoryType);
    public List<Menu> searchMenusByName(String name);
    public Short getMenuStockById(String menuId);
    public void orderMenu(List<Menu> menus);
    public List<MenuWrapper> getMenusByTenantV01(String tenantId);
}
