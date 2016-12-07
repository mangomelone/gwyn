package com.genosharing.gwyn;

/**
 * Created by hackathon on 06.12.16.
 */
public class Offer {

    private Product product;
    private Price price;
    private User vendor;

    public Offer(Product product, Price price, User vendor) {
        this.product = product;
        this.price = price;
        this.vendor = vendor;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
