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

    private static final double SCALE = 0.5;
    private static final double PROFILE_SCALE = 0.25;

    public static List<Offer> getOffers(Activity activity) {
        List<Offer> offers = new ArrayList<>();

        Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
        Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");

        Product huepfburg = new Product("Hüpfhaus", "Ganz wunderbare Hüpfburg", createBitmap(activity, R.drawable.suchergebnis1, DummyData.SCALE));
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel", createBitmap(activity, R.drawable.suchergebnis2, DummyData.SCALE));
        String description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        Product huepfhaus = new Product("Hüpfburg", description, createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE));

        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);

        User verkaeufer1 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis1potrait, DummyData.PROFILE_SCALE), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis2potrait, DummyData.PROFILE_SCALE), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis3portrait, DummyData.PROFILE_SCALE), low, activity.getString(R.string.userprofil));

        List<String> zubehoer1 = new ArrayList<>();
        zubehoer1.add("Pumpe");
        zubehoer1.add("Ganz viel Spaß");

        Offer offer1 = new Offer(huepfburg, zubehoer1,  _20EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(huepfinsel, zubehoer1,  _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(huepfhaus, zubehoer1,  _10EuroProTag, verkaeufer2);

        for (int i = 0; i < 3; i++)
        {
            offers.add(offer1);
            offers.add(offer2);
            offers.add(offer3);
        }
        return offers;
    }

    public static List<Offer> getMeistGeliehen(Activity activity) {
        List<Offer> offers = new ArrayList<>();

        Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
        Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");

        Product tesla = new Product("Tesla", activity.getString(R.string.desc_tesla),
                createBitmap(activity, R.drawable.suchergebnis1, DummyData.SCALE));

        Product partykuehlschrank = new Product("Edelstahl-Partykühlschrank", activity.getString(R.string.desc_partykuehlschrank), createBitmap(activity, R.drawable.suchergebnis2, DummyData.SCALE));

        Product karaokemaschine = new Product("Karaokemaschine", activity.getString(R.string.desc_karaoke), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE));

        Product snowboard = new Product("Snowboard Salomon", activity.getString(R.string.desc_snowboard), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE));

        Product bohrmaschine = new Product("Metabo Bohrmaschine SEB1000", activity.getString(R.string.desc_bohrmaschine), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE));

        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);

        User verkaeufer1 = new User("Stefan", "Birghan", createBitmap(activity, R.drawable.suchergebnis1potrait, DummyData.PROFILE_SCALE), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Theo", "Bender", createBitmap(activity, R.drawable.suchergebnis2potrait, DummyData.PROFILE_SCALE), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis3portrait, DummyData.PROFILE_SCALE), low, activity.getString(R.string.userprofil));

        List<String> zubehoer1 = new ArrayList<>();
        zubehoer1.add("Pumpe");
        zubehoer1.add("Ganz viel Spaß");

        Offer offer1 = new Offer(tesla, zubehoer1,  _20EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(partykuehlschrank, zubehoer1,  _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(karaokemaschine, zubehoer1,  _10EuroProTag, verkaeufer2);
        Offer offer4 = new Offer(snowboard, zubehoer1,  _10EuroProTag, verkaeufer2);
        Offer offer5 = new Offer(bohrmaschine, zubehoer1,  _10EuroProTag, verkaeufer2);

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);

        return offers;
    }

    public static List<Offer> getAmBestenBewertet(Activity activity) {
        List<Offer> offers = new ArrayList<>();

        Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
        Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");

        Product huepfburg = new Product("Hüpfhaus", "Ganz wunderbare Hüpfburg", createBitmap(activity, R.drawable.suchergebnis1, DummyData.SCALE));
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel", createBitmap(activity, R.drawable.suchergebnis2, DummyData.SCALE));
        Product huepfhaus = new Product("Hüpfburg", "Ganz wunderbares Hüpfhaus", createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE));

        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);

        User verkaeufer1 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis1potrait, DummyData.PROFILE_SCALE), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis2potrait, DummyData.PROFILE_SCALE), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis3portrait, DummyData.PROFILE_SCALE), low, activity.getString(R.string.userprofil));

        List<String> zubehoer1 = new ArrayList<>();
        zubehoer1.add("Pumpe");
        zubehoer1.add("Ganz viel Spaß");

        Offer offer1 = new Offer(huepfburg, zubehoer1,  _20EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(huepfinsel, zubehoer1,  _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(huepfhaus, zubehoer1,  _10EuroProTag, verkaeufer2);

        for (int i = 0; i < 3; i++)
        {
            offers.add(offer1);
            offers.add(offer2);
            offers.add(offer3);
        }
        return offers;
    }

    private static Bitmap createBitmap(Activity activity, int id, double scale) {
        Bitmap image = BitmapFactory.decodeResource(activity.getResources(), id);
        Bitmap imageResized = Bitmap.createScaledBitmap(image, (int) (image.getWidth() *  scale), (int) (image.getHeight() * scale), true);
        return imageResized;
    }
}
