package com.genosharing.gwyn;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by hackathon on 07.12.16.
 */
public class User {

    private String vorname;
    private String nachname;
    private Bitmap profilePic;
    private Rating rating;
    private String description;

    public User(String vorname, String nachname, Bitmap profilePic, Rating rating, String description) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.profilePic = profilePic;
        this.rating = rating;
        this.description = description;
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

    public Bitmap getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Bitmap profilePic) {
        this.profilePic = profilePic;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName()
    {
        return this.vorname + " " + this.nachname;
    }
}
