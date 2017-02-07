package com.genosharing.gwyn.model;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hackathon on 06.12.16.
 */
public class Product {

    private String name;
    private String description;
    private List<Bitmap> images;
    private List<String> tags;

    public Product(String name, String description, List<Bitmap> images, List<String> tags) {
        this.name = name;
        this.description = description;
        this.images = images;
        this.tags = tags;
    }

    public Product(String name, String description, Bitmap image, List<String> tags) {
        this.name = name;
        this.description = description;
        List<Bitmap> images = new ArrayList<>();
        images.add(image);
        this.images = images;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bitmap> getImages() {
        return images;
    }

    public void setImages(List<Bitmap> image) {
        this.images = image;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
