package org.tebogomkhize.projects.controller;

import org.tebogomkhize.projects.dto.ImageResult;


public interface ImageController {
    ImageResult findImgById(int id);
}