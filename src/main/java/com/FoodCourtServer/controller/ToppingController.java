package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.Topping;
import com.FoodCourtServer.service.ToppingService;
import com.FoodCourtServer.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/get-topping", method = RequestMethod.GET)
    ResponseEntity<?> getToppings() {
        LOGGER.info("get toppings");
        List<Topping> toppings = toppingService.getToppings();

        if (toppings == null) {
            LOGGER.error("toppings not found");

            return new ResponseEntity<>(new CustomErrorType("Topping not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toppings, HttpStatus.OK);
    }

    ResponseEntity<?> createTopping(
            @RequestPart("metadata") Topping topping,
            @RequestPart("file") MultipartFile imageFile
            ) {
        return null;


    }

    ResponseEntity<?> editTopping() {
        return null;
    }

    ResponseEntity<?> deleteTopping() {
        return null;
    }
}
