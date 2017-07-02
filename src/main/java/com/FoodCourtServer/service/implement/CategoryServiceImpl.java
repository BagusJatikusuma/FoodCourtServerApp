/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.dao.CategoryDao;
import com.FoodCourtServer.model.Category;
import com.FoodCourtServer.service.CategoryService;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;

import com.FoodCourtServer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bagus
 */
@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ImageService imageService;

    @Override
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> getCategoriesByCategoryType(Boolean categoryType) {
        return categoryDao.findByCategoryType(categoryType);
    }

    @Override
    public void saveCategory(Category category, MultipartFile imageFile) throws IOException {
        category.setImage(category.getId());

        imageService.uploadImage(imageFile,"category", category.getId());

        categoryDao.save(category);
    }

    @Override
    public void updateCategory(Category category, MultipartFile imageFile) throws IOException {
        category.setImage(category.getId());

        imageService.uploadImage(imageFile,"category",category.getId()+".jpg");

        categoryDao.save(category);
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryDao.deleteById(categoryId);
    }

    @Override
    public Category getCategoryById(String categoryId) {
        return categoryDao.findById(categoryId);
    }
    
}
