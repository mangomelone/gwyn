package com.genosharing.gwyn;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by hackathon on 06.12.16.
 */
public class DummyData {

    public static List<Offer> getOffers(Activity activity) {
        List<Offer> offers = new ArrayList<>();
        Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
        Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");
        double scale = 0.5;
        double profileScale = 0.25;
        Product huepfburg = new Product("Hüpfhaus", "Ganz wunderbare Hüpfburg", createBitmap(activity, R.drawable.suchergebnis1, scale));
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel", createBitmap(activity, R.drawable.suchergebnis2, scale));
        Product huepfhaus = new Product("Hüpfburg", "Ganz wunderbares Hüpfhaus", createBitmap(activity, R.drawable.suchergebnis3, scale));
        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);
        User verkaeufer1 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis1potrait, profileScale), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis2potrait, profileScale), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis3portrait, profileScale), low, activity.getString(R.string.userprofil));
        Offer offer1 = new Offer(huepfburg, _20EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(huepfinsel, _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(huepfhaus, _10EuroProTag, verkaeufer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        return offers;
    }

    private static Bitmap createBitmap(Activity activity, int id, double scale) {
        Bitmap image = BitmapFactory.decodeResource(activity.getResources(), id);
        Bitmap imageResized = Bitmap.createScaledBitmap(image, (int) (image.getWidth() *  scale), (int) (image.getHeight() * scale), true);
        return imageResized;
    }
}
