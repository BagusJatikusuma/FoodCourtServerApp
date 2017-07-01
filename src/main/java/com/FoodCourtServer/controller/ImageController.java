package com.FoodCourtServer.controller;

import com.FoodCourtServer.service.ImageService;
import com.FoodCourtServer.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by bagus on 29/06/17.
 */
@RestController
@RequestMapping("/images")
public class ImageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/get-tenant-image/{tenantId}", method = RequestMethod.GET)
    ResponseEntity<?> getTenantImage(@PathVariable("tenantId") String tenantId) {
        byte[] image;

        try {
            image = imageService.getImage("tenant", tenantId);
        } catch (IOException e) {
            LOGGER.error("cannot read image");
            return new ResponseEntity<>(
                    new CustomErrorType("cannot read image"),
                    HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(
                image,
                getImageHttpHeader(image),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get-category-image/{categoryId}", method = RequestMethod.GET)
    ResponseEntity<?> getCategoryImage(@PathVariable("categoryId") String categoryId) {
        byte[] image;

        try {
            image = imageService.getImage("category", categoryId);
        } catch (IOException e) {
            LOGGER.error("cannot read image");
            return new ResponseEntity<>(
                    new CustomErrorType("cannot read image"),
                    HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(
                image,
                getImageHttpHeader(image),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get-menu-image/{menuId}", method = RequestMethod.GET)
    ResponseEntity<?> getMenuImage(@PathVariable("menuId") String menuId) {
        byte[] image;

        try {
            image = imageService.getImage("menu", menuId);
        } catch (IOException e) {
            LOGGER.error("cannot read image");
            return new ResponseEntity<>(
                    new CustomErrorType("cannot read image"),
                    HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(
                image,
                getImageHttpHeader(image),
                HttpStatus.OK);
    }

    private HttpHeaders getImageHttpHeader(byte[] image) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return headers;
    }
}