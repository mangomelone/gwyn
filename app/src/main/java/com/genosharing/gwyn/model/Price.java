package com.genosharing.gwyn.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by hackathon on 06.12.16.
 */
public class Price {

    private BigDecimal amount;
    private Currency currency;
    private String unit;

    public Price(BigDecimal betrag, Currency currency, String einheit) {
        this.amount = betrag;
        this.currency = currency;
        this.unit = einheit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return amount + currency.getSymbol() + "/" + unit;
    }
}
