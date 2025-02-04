package org.tebogomkhize.projects.model;

import org.tebogomkhize.projects.dto.ImageResult;
import org.tebogomkhize.projects.dataaccess.dao.ImageDAO;


public class ImageServiceImpl implements ImageService {
    private ImageDAO imageDAO;

    public ImageServiceImpl() {
        this.imageDAO = new ImageDAO();
    }
    @Override
    public ImageResult findImgById(int id) {
        return this.imageDAO.findImgById(id);
    }
}