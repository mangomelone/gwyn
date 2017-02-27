package com.genosharing.gwyn.model;

import org.joda.time.Interval;

import java.util.List;

/**
 * Created by Corinna on 27.02.2017.
 */

public class Inquiry {

    private List<Accessory> selectedAccessories;
    private InsuranceType insuranceType;
    private ExchangeType exchangeType;
    private Interval rentingTime;

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
