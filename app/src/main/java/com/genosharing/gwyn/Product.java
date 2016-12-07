package com.genosharing.gwyn;

import android.media.Image;

/**
 * Created by hackathon on 06.12.16.
 */
public class Product {

    private String name;
    private String description;
    private Image image;

    public Product(String name, String description, Image image) {
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
}
