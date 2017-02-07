package com.genosharing.gwyn.model;

import java.util.List;

/**
 * Created by hackathon on 06.12.16.
 */
public class Offer {

    private Product product;
    private List<String> zubehoerListe;
    private Price price;
    private User vendor;

    public Offer(Product product, List<String> zubehoerListe, Price price, User vendor) {
        this.product = product;
        this.zubehoerListe = zubehoerListe;
        this.price = price;
        this.vendor = vendor;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<String> getZubehoerListe() {
        return zubehoerListe;
    }

    public void setZubehoerListe(List<String> zubehoerListe) {
        this.zubehoerListe = zubehoerListe;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return product.getName() + " - " + price;
    }
}
