/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Category;
import com.FoodCourtServer.service.CategoryService;
import com.FoodCourtServer.util.CustomErrorType;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author bagus
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    public static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/get-categories",method = RequestMethod.GET)
    public ResponseEntity<?> getListCategory() {
        LOGGER.info("fetching categories");

        List<Category> categories = categoryService.getCategories();

        if (categories == null) {
            LOGGER.error("categories not found");

            return new ResponseEntity(new CustomErrorType("category not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-category-by-id/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") String categoryId) {
        LOGGER.info("fetching category by id : "+categoryId);

        Category category = categoryService.getCategoryById(categoryId);

        if (category == null) {
            LOGGER.error("category with id : "+categoryId+" not found");

            return new ResponseEntity<>(new CustomErrorType("category not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-categories-by-type/{type}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriesByTipeKategori(@PathVariable("type") Boolean type) {
        LOGGER.info("fetching categories with "+type.toString()+" type");

        List<Category> categories = categoryService.getCategoriesByCategoryType(type);

        if (categories == null) {
            LOGGER.error("categories with "+type.toString()+" type not found");

            return new ResponseEntity(new CustomErrorType("category not found"), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        LOGGER.info("creating "+category.toString());

        categoryService.saveCategory(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Category> editCategory(@RequestBody Category category) {
        LOGGER.info("edit "+category.toString());

        categoryService.updateCategory(category);

        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.DELETE)
    public  ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId) {
        LOGGER.info("delete "+categoryId+" Category");

        categoryService.deleteCategory(categoryId);

        return new ResponseEntity<Object>(categoryId+"deleted",HttpStatus.OK);
    }

}
