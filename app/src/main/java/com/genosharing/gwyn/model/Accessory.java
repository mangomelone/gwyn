package com.genosharing.gwyn.model;

/**
 * Created by Corinna on 27.02.2017.
 */

public class Accessory {

    private String name;
    private Price price;

    public Accessory(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
