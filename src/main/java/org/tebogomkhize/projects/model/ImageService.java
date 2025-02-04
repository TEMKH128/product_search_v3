package org.tebogomkhize.projects.model;

import org.tebogomkhize.projects.dto.ImageResult;


public interface ImageService {
    ImageResult findImgById(int id);
}