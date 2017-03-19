package com.genosharing.gwyn.model;

import org.joda.time.Interval;

import java.util.List;

/**
 * Created by Corinna on 27.02.2017.
 */

public class Inquiry {

    private Offer forOffer;
    private List<Accessory> selectedAccessories;
    private InsuranceType insuranceType;
    private ExchangeType exchangeType;
    private Interval rentingTime;

    public Inquiry(Offer forOffer)
    {
        this(forOffer, null, null, null, null);
    }

    public Inquiry(Offer forOffer, List<Accessory> selectedAccessories, InsuranceType insuranceType, ExchangeType exchangeType, Interval rentingTime) {
        this.forOffer = forOffer;
        this.selectedAccessories = selectedAccessories;
        this.insuranceType = insuranceType;
        this.exchangeType = exchangeType;
        this.rentingTime = rentingTime;
    }

    public Offer getForOffer() {
        return forOffer;
    }

    public void setForOffer(Offer forOffer) {
        this.forOffer = forOffer;
    }

    public List<Accessory> getSelectedAccessories() {
        return selectedAccessories;
    }

    public void setSelectedAccessories(List<Accessory> selectedAccessories) {
        this.selectedAccessories = selectedAccessories;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Interval getRentingTime() {
        return rentingTime;
    }

    public void setRentingTime(Interval rentingTime) {
        this.rentingTime = rentingTime;
    }
}
