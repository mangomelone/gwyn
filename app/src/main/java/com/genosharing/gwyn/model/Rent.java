package com.genosharing.gwyn.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Corinna on 27.02.2017.
 */

public class Rent {

    private Price price;
    private PriceUnit unit;

    public Rent(Price price, PriceUnit unit) {
        this.price = price;
        this.unit = unit;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public PriceUnit getUnit() {
        return unit;
    }

    public void setUnit(PriceUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return price.getAmount() + price.getCurrency().getSymbol() + "/" + unit;
    }
}
