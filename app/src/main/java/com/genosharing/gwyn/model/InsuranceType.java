package com.genosharing.gwyn.model;

/**
 * Created by Corinna on 27.02.2017.
 */

public enum InsuranceType {
    HighRisk("Hohes Risiko"),
    SomeRisk("Etwas Risiko"),
    NoRisk("Kein Risiko");

    private String name;

    private InsuranceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
