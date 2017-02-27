package com.genosharing.gwyn.model;

import java.util.List;

/**
 * Created by hackathon on 06.12.16.
 */
public class Offer {

    private Product product;
    private List<String> included;
    private List<Accessory> accessories;
    private Rent rent;
    private User vendor;
    private Availability availability;

    public Offer(Product product, List<String> included, List<Accessory> accessories, Rent rent, User vendor, Availability availabilty) {
        this.product = product;
        this.included = included;
        this.accessories = accessories;
        this.rent = rent;
        this.vendor = vendor;
        this.availability = availabilty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<String> getIncluded() {
        return included;
    }

    public void setIncluded(List<String> included) {
        this.included = included;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return product.getName() + " - " + rent;
    }
}
