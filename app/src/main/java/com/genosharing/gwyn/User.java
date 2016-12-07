package com.genosharing.gwyn;

/**
 * Created by hackathon on 07.12.16.
 */
public class User {

    private String vorname;
    private String nachname;

    public User(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
