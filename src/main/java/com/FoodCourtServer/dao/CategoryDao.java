/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Category;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author bagus
 */
public interface CategoryDao extends Repository<Category, Long>{
    List<Category> findByCategoryType(Boolean categoryType);

    List<Category> findAll();

    void  save(Category category);

    Category findById(String categoryId);

    @Modifying
    @Query("update Category c set c.name = ?2, c.categoryType = ?3 where c.id = ?1")
    void updateCategory(String id, String name, Boolean categoryType);

    void deleteById(String categoryId);
}
