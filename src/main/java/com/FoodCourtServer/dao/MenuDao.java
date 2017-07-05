/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Menu;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author bagus
 */
public interface MenuDao extends Repository<Menu, Long>{
    public Menu findById(String menuId);

    public List<Menu> findAll();

    public List<Menu> findByCategory_Id(String idCategory);

    public List<Menu> findByCategory_CategoryType(Boolean categoryType);

    public List<Menu> findByTenant_Id(String tenantId);

    public List<Menu> findByNameContaining(String name);

    @Query("select m.stock from Menu m where m.id = :id")
    public Short getMenuStockById(@Param("id") String menuId);

}
