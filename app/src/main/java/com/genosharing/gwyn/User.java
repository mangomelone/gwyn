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

    public User(String vorname, String nachname, Bitmap profilePic) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.profilePic = profilePic;
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
}
