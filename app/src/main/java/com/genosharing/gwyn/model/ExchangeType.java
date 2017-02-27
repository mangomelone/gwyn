package com.genosharing.gwyn.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Corinna on 27.02.2017.
 */

public enum ExchangeType {
    SHIPPING("Versand"),
    PICKUP("Abholung"),
    GWYN("GWYN-Station");

    private String name;
    private Price price;

    private ExchangeType(String name)
    {
        this(name, new Price(BigDecimal.ZERO, Currency.getInstance(Locale.GERMANY)));
    }

    ExchangeType(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
