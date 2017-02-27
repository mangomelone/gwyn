package com.genosharing.gwyn.model;

/**
 * Created by Corinna on 27.02.2017.
 */

public enum PriceUnit {
    DAY("Tag"),
    WEEK("Woche"),
    MONTH("Monat"),
    YEAR("Jahr");

    private String name;

    private PriceUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
