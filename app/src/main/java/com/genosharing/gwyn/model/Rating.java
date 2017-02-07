package com.genosharing.gwyn.model;

/**
 * Created by Blackrental on 07.12.2016.
 */

public class Rating {

    private int value;

    public Rating(int rating) {
        setValue(rating);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        checkValidity(value);
        this.value = value;
    }

    private void checkValidity(int value) {
        if (!(value > 1 && value <= 5))
            throw new IllegalArgumentException("Für das Rating sind nur Werte zwischen 1 und 5 zulässig.");
    }
}
