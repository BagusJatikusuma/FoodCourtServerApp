/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.dao.MenuDao;
import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.service.MenuService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bagus
 */
@Service("MenuService")
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;
    
    @Override
    public Menu getMenuById(String menuId) {
        return menuDao.findById(menuId);
    }

    @Override
    public List<Menu> getMenusByTenant(String tenantId) {
        return menuDao.findByTenant_Id(tenantId);
    }

    @Override
    public List<Menu> getMenusByCategory(String categoryId) {
        return menuDao.findByCategory_Id(categoryId);
    }

    @Override
    public List<Menu> searchMenusByName(String name) {
        return menuDao.findByNameContaining(name);
    }

    @Override
    public Integer getMenuStockById(String menuId) {
        return menuDao.getMenuStockById(menuId);
    }

    @Override
    public void orderMenu(List<Menu> menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> getMenusByCategoryType(Boolean categoryType) {
        return menuDao.findByCategory_CategoryType(categoryType);
    }

    @Override
    public List<Menu> getMenus() {
        return menuDao.findAll();
    }
    
}
