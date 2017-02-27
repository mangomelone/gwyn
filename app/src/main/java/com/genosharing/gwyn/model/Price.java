package com.genosharing.gwyn.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by hackathon on 06.12.16.
 */
public class Price {

    private BigDecimal amount;
    private Currency currency;

    public Price(BigDecimal amount) {
        this(amount, Currency.getInstance(Locale.GERMANY));
    }

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
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
}
