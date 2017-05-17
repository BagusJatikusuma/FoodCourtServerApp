/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Menu;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author bagus
 */
public interface MenuDao extends Repository<Menu, Long>{
    public Menu findById(String menuId);

    public List<Menu> findAll();

    public List<Menu> findByCategory_Id(String idCategory);

    public List<Menu> findByCategory_CategoryType(Boolean categoryType);

    public List<Menu> findByTenant_Id(String outletId);
    
}
