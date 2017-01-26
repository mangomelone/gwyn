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

    private static final Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _12EuroProTag = new Price(BigDecimal.valueOf(12), Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _18EuroProTag = new Price(BigDecimal.valueOf(18), Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");
    private static final Price _25EuroProTag = new Price(BigDecimal.valueOf(25), Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _29EuroProTag = new Price(BigDecimal.valueOf(29), Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _39EuroProTag = new Price(BigDecimal.valueOf(39), Currency.getInstance(Locale.GERMANY), "Tag");
    private static final Price _599EuroProWoche = new Price(BigDecimal.valueOf(599), Currency.getInstance(Locale.GERMANY), "Woche");

    public static List<Offer> getOffers(Activity activity) {
        List<Offer> offers = new ArrayList<>();

        List<String> tags = new ArrayList<>();
        tags.add("Hüpfburg");

        Product huepfburg = new Product("Hüpfhaus", "Ganz wunderbare Hüpfburg", createBitmap(activity, R.drawable.suchergebnis1, DummyData.SCALE), tags);
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel", createBitmap(activity, R.drawable.suchergebnis2, DummyData.SCALE), tags);
        Product huepfhaus = new Product("Hüpfburg", activity.getString(R.string.lorem_ipsum), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

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

        List<String> tags = new ArrayList<>();
        tags.add("Beliebt");

        Product tesla = new Product("Tesla", activity.getString(R.string.desc_tesla),
                createBitmap(activity, R.drawable.suchergebnis1, DummyData.SCALE), tags);

        Product partykuehlschrank = new Product("Edelstahl-Partykühlschrank", activity.getString(R.string.desc_partykuehlschrank), createBitmap(activity, R.drawable.suchergebnis2, DummyData.SCALE), tags);

        Product karaokemaschine = new Product("Karaokemaschine", activity.getString(R.string.desc_karaoke), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product snowboard = new Product("Snowboard Salomon", activity.getString(R.string.desc_snowboard), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product bohrmaschine = new Product("Metabo Bohrmaschine SEB1000", activity.getString(R.string.desc_bohrmaschine), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product xbox = new Product("Xbox One S", activity.getString(R.string.desc_xbox), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product unterwasserkamera = new Product("Key Mission 170", activity.getString(R.string.desc_unterwasserkamera), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product htcvive  = new Product("HTC Vive", activity.getString(R.string.desc_unterwasserkamera), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Product zapfanlage = new Product("Bierzapfanlage", activity.getString(R.string.desc_unterwasserkamera), createBitmap(activity, R.drawable.suchergebnis3, DummyData.SCALE), tags);

        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);

        User verkaeufer1 = new User("Stefan", "Birghan", createBitmap(activity, R.drawable.suchergebnis1potrait, DummyData.PROFILE_SCALE), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Theo", "Bender", createBitmap(activity, R.drawable.suchergebnis2potrait, DummyData.PROFILE_SCALE), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", createBitmap(activity, R.drawable.suchergebnis3portrait, DummyData.PROFILE_SCALE), low, activity.getString(R.string.userprofil));

        List<String> zubehoer1 = new ArrayList<>();
        zubehoer1.add("Sonnenbrille");
        zubehoer1.add("Navigationsgerät");

        List<String> zubehoer2 = new ArrayList<>();
        zubehoer2.add("20er Pack Energiedrinks");
        zubehoer2.add("1 Kiste Bier");

        List<String> zubehoer3 = new ArrayList<>();
        zubehoer3.add("Halsbonbons");
        zubehoer3.add("Ohrstöpsel");

        List<String> zubehoer4 = new ArrayList<>();
        zubehoer4.add("Helm");
        zubehoer4.add("Getönte Skibrille");

        List<String> zubehoer5 = new ArrayList<>();
        zubehoer5.add("Steinbohrer Set");
        zubehoer5.add("Metallbohrer Set");
        zubehoer5.add("Holzbohrer Set");

        List<String> zubehoer6 = new ArrayList<>();
        zubehoer6.add("2ter Wireless Controller");
        zubehoer6.add("Spiel Halo 5");
        zubehoer6.add("Spiel Fifa17");

        List<String> zubehoer7 = new ArrayList<>();
        zubehoer7.add("Taucherbrille");
        zubehoer7.add("Schnorchel");
        zubehoer7.add("Flossen");

        List<String> zubehoer8 = new ArrayList<>();
        zubehoer8.add("Gaming PC");
        zubehoer8.add("4K Monitor");
        zubehoer8.add("Brillenputztücher");

        List<String> zubehoer9 = new ArrayList<>();
        zubehoer9.add("10 Liter Fass Pils");
        zubehoer9.add("Pilsgläser");
        zubehoer9.add("Bierdeckel");

        Offer offer1 = new Offer(tesla, zubehoer1,  _599EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(partykuehlschrank, zubehoer2,  _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(karaokemaschine, zubehoer3,  _10EuroProTag, verkaeufer2);
        Offer offer4 = new Offer(snowboard, zubehoer4,  _25EuroProTag, verkaeufer2);
        Offer offer5 = new Offer(bohrmaschine, zubehoer5,  _10EuroProTag, verkaeufer2);
        Offer offer6 = new Offer(xbox, zubehoer6,  _29EuroProTag, verkaeufer2);
        Offer offer7 = new Offer(unterwasserkamera, zubehoer7,  _18EuroProTag, verkaeufer2);
        Offer offer8 = new Offer(htcvive, zubehoer8,  _39EuroProTag, verkaeufer2);
        Offer offer9 = new Offer(zapfanlage, zubehoer9,  _18EuroProTag, verkaeufer2);

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);
        offers.add(offer6);
        offers.add(offer7);
        offers.add(offer8);
        offers.add(offer9);

        return offers;
    }

    private static Bitmap createBitmap(Activity activity, int id, double scale) {
        Bitmap image = BitmapFactory.decodeResource(activity.getResources(), id);
        Bitmap imageResized = Bitmap.createScaledBitmap(image, (int) (image.getWidth() *  scale), (int) (image.getHeight() * scale), true);
        return imageResized;
    }

    public static List<Offer> getAllOffers(Activity activity)
    {
        List<Offer> offers = getOffers(activity);
        offers.addAll(getMeistGeliehen(activity));
        return offers;
    }
}
