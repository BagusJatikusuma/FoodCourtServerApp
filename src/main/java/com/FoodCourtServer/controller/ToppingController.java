package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Topping;
import com.FoodCourtServer.service.ToppingService;
import com.FoodCourtServer.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
@RestController
@RequestMapping("/topping")
public class ToppingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToppingController.class);

    @Autowired
    private ToppingService toppingService;

    @RequestMapping(value = "/get-toppings", method = RequestMethod.GET)
    ResponseEntity<?> getToppings() {
        LOGGER.info("get toppings");
        List<Topping> toppings = toppingService.getToppings();

        if (toppings == null) {
            LOGGER.error("toppings not found");

            return new ResponseEntity<>(new CustomErrorType("ToppingCompared not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toppings, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<?> createTopping(
            @RequestPart("metadata") Topping topping,
            @RequestPart("file") MultipartFile imageFile
            ) {
        LOGGER.info("create topping");
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    ResponseEntity<?> editTopping(
            @RequestPart("metadata") Topping topping,
            @RequestPart("file") MultipartFile imageFile
            ) {
        LOGGER.info("edit topping");
        return null;
    }

    @RequestMapping(value = "/delete/{toppingId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteTopping(@PathVariable("toppingId") String toppingId) {
        LOGGER.info("delete topping "+toppingId);

        toppingService.deleteTopping(toppingId);

        return new ResponseEntity<>(toppingId+"deleted",HttpStatus.OK);

    }

    @RequestMapping(value = "/test-get-stock/{toppingId}", method = RequestMethod.GET)
    ResponseEntity<?> getStockById(@PathVariable("toppingId") String toppingId) {
        LOGGER.info("get "+ toppingId +" stock");

        short stock = toppingService.getStockById(toppingId);

        return new ResponseEntity<>(stock,HttpStatus.OK);
    }
}
