/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Category;
import com.FoodCourtServer.model.Menu;
import java.util.List;

/**
 *
 * @author bagus
 */
public interface CategoryService {
    public Category getCategoryById(String categoryId);
    public List<Category> getCategories();
    public List<Category> getCategoriesByCategoryType(Boolean categoryType);
    public void saveCategory(Category category);
    public void updateCategory(Category category);
}
