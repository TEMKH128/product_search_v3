package org.tebogomkhize.projects.controller;

import org.tebogomkhize.projects.dto.ImageResult;
import org.tebogomkhize.projects.model.ImageService;
import org.tebogomkhize.projects.model.ImageServiceImpl;


public class ImageControllerImpl implements ImageController {
    private ImageService imageService;

    public ImageControllerImpl() {
        this.imageService = new ImageServiceImpl();
    }
    @Override
    public ImageResult findImgById(int id) {
        return this.imageService.findImgById(id);
    }
}