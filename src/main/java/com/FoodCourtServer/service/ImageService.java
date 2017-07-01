package com.FoodCourtServer.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by bagus on 01/07/17.
 */
public interface ImageService {
    void uploadImage(MultipartFile file, String imageFolder, String imageName) throws IOException;
    byte[] getImage(String imageFolder, String imageName) throws IOException;
}
