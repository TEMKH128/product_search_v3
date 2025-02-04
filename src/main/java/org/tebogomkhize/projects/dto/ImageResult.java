package org.tebogomkhize.projects.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;


@Getter
@AllArgsConstructor
public class ImageResult {
    private boolean outcome;
    private byte[] image;
}