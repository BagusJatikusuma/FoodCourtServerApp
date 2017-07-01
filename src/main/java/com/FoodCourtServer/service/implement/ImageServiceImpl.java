package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.controller.TenantController;
import com.FoodCourtServer.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bagus on 01/07/17.
 */
@Service("ImageService")
public class ImageServiceImpl implements ImageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Override
    public void uploadImage(MultipartFile file, String imageFolder, String imageName) throws IOException {
        if (file.isEmpty()) throw new NullPointerException();

        byte[] bytes = file.getBytes();

        Path path = Paths.get("/home/bagus/FoodCourtAppImages/"+imageFolder+"/"+imageName+".jpg");

        Files.write(path, bytes);
    }

    @Override
    public byte[] getImage(String imageFolder, String imageName) throws IOException {
        File imgPath = new File("/home/bagus/FoodCourtAppImages/"+imageFolder+"/"+imageName+".jpg");

        byte[] image = Files.readAllBytes(imgPath.toPath());

        return image;
    }
}
