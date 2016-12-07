package com.genosharing.gwyn;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by hackathon on 06.12.16.
 */
public class Product {

    private String name;
    private String description;
    private Bitmap image;

    public Product(String name, String description, Bitmap image) {
        this.name = name;
        this.description = description;
        this.image = image;
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

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
