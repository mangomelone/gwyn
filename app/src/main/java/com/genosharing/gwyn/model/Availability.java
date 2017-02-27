package com.genosharing.gwyn.model;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Date;
import java.util.List;

/**
 * Created by Corinna on 27.02.2017.
 */

public class Availability {

    private Interval fromUntil;
    private List<DateTime> exceptions;

    public Availability(Interval fromUntil, List<DateTime> exceptions) {
        this.fromUntil = fromUntil;
        this.exceptions = exceptions;
    }

    public Interval getFromUntil() {
        return fromUntil;
    }

    public void setFromUntil(Interval fromUntil) {
        this.fromUntil = fromUntil;
    }

    public List<DateTime> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<DateTime> exceptions) {
        this.exceptions = exceptions;
    }
}
