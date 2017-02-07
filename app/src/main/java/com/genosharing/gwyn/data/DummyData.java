package com.genosharing.gwyn.data;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.genosharing.gwyn.R;
import com.genosharing.gwyn.model.Offer;
import com.genosharing.gwyn.model.Price;
import com.genosharing.gwyn.model.Product;
import com.genosharing.gwyn.model.Rating;
import com.genosharing.gwyn.model.User;

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

        List<String> beliebtTag = new ArrayList<>();
        beliebtTag.add("Beliebt");

        List<String> huepfburgTags = new ArrayList<>();
        huepfburgTags.add("Hüpfburg");
        huepfburgTags.add("Freizeit");
        huepfburgTags.add("Kinder");
        huepfburgTags.add("Spaß");

        Product tesla = new Product("Tesla", activity.getString(R.string.desc_tesla),
                createImages(activity, R.drawable.tesla), beliebtTag);

        Product partykuehlschrank = new Product("Edelstahl-Partykühlschrank", activity.getString(R.string.desc_partykuehlschrank),
                createImages(activity, R.drawable.partykuehlschrank), beliebtTag);

        Product karaokemaschine = new Product("Karaokemaschine", activity.getString(R.string.desc_karaoke),
                createImages(activity, R.drawable.karaokebox), beliebtTag);

        Product snowboard = new Product("Snowboard Salomon", activity.getString(R.string.desc_snowboard),
                createImages(activity, R.drawable.tesla), beliebtTag);


        Product bohrmaschine = new Product("Metabo Bohrmaschine SEB1000", activity.getString(R.string.desc_bohrmaschine),
                createImages(activity, R.drawable.schlagbohrmaschine_bild1), beliebtTag);

        Product xbox = new Product("Xbox One S", activity.getString(R.string.desc_xbox),
                createImages(activity, R.drawable.x_box), beliebtTag);

        Product unterwasserkamera = new Product("Key Mission 170", activity.getString(R.string.desc_unterwasserkamera),
                createImages(activity, R.drawable.unterwasserkamera), beliebtTag);

        Product htcvive  = new Product("HTC Vive", activity.getString(R.string.desc_unterwasserkamera),
                createImages(activity, R.drawable.htc_vive), beliebtTag);

        Product zapfanlage = new Product("Bierzapfanlage", activity.getString(R.string.desc_unterwasserkamera),
                createImages(activity, R.drawable.zapfanlage), beliebtTag);

        Product huepfburg = new Product("Hüpfhaus", "Ganz wunderbare Hüpfburg",
                createImages(activity, R.drawable.beschreibung1, R.drawable.beschreibung2, R.drawable.beschreibung3), huepfburgTags);
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel",
                createImages(activity, R.drawable.beschreibung4, R.drawable.beschreibung5, R.drawable.beschreibung6), huepfburgTags);
        Product huepfhaus = new Product("Hüpfburg", activity.getString(R.string.lorem_ipsum),
                createImages(activity, R.drawable.happyhop_huepfburg_transparent, R.drawable.huepfburg_castle, R.drawable.beschreibung3), huepfburgTags);

        Rating low = new Rating(2);
        Rating middle = new Rating(4);
        Rating high = new Rating(5);

        User verkaeufer1 = new User("Stefan", "Birghan", BitmapFactory.decodeResource(activity.getResources(), R.drawable.suchergebnis1potrait), middle, activity.getString(R.string.userprofil));
        User verkaeufer2 = new User("Theo", "Bender", BitmapFactory.decodeResource(activity.getResources(), R.drawable.suchergebnis2potrait), high, activity.getString(R.string.userprofil));
        User verkaeufer3 = new User("Max", "Musterverkäufer", BitmapFactory.decodeResource(activity.getResources(), R.drawable.suchergebnis3portrait), low, activity.getString(R.string.userprofil));

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

        List<String> zubehoerHuepf = new ArrayList<>();
        zubehoer1.add("Pumpe");
        zubehoer1.add("Ganz viel Spaß");

        Offer offer1 = new Offer(tesla, zubehoer1,  _599EuroProWoche, verkaeufer1);
        Offer offer2 = new Offer(partykuehlschrank, zubehoer2,  _20EuroProWoche, verkaeufer3);
        Offer offer3 = new Offer(karaokemaschine, zubehoer3,  _10EuroProTag, verkaeufer2);
        Offer offer4 = new Offer(snowboard, zubehoer4,  _25EuroProTag, verkaeufer2);
        Offer offer5 = new Offer(bohrmaschine, zubehoer5,  _10EuroProTag, verkaeufer2);
        Offer offer6 = new Offer(xbox, zubehoer6,  _29EuroProTag, verkaeufer2);
        Offer offer7 = new Offer(unterwasserkamera, zubehoer7,  _18EuroProTag, verkaeufer2);
        Offer offer8 = new Offer(htcvive, zubehoer8,  _39EuroProTag, verkaeufer2);
        Offer offer9 = new Offer(zapfanlage, zubehoer9,  _18EuroProTag, verkaeufer2);
        Offer offer10 = new Offer(huepfburg, zubehoerHuepf,  _20EuroProWoche, verkaeufer1);
        Offer offer11 = new Offer(huepfinsel, zubehoerHuepf,  _20EuroProWoche, verkaeufer3);
        Offer offer12 = new Offer(huepfhaus, zubehoerHuepf,  _10EuroProTag, verkaeufer2);

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);
        offers.add(offer6);
        offers.add(offer7);
        offers.add(offer8);
        offers.add(offer9);
        offers.add(offer10);
        offers.add(offer11);
        offers.add(offer12);

        return offers;
    }

    private static Bitmap createBitmap(Activity activity, int id, double scale) {
        Bitmap image = BitmapFactory.decodeResource(activity.getResources(), id);
        Bitmap imageResized = Bitmap.createScaledBitmap(image, (int) (image.getWidth() *  scale), (int) (image.getHeight() * scale), true);
        return imageResized;
    }

    private static List<Bitmap> createImages(Activity activity, int... imageIDs)
    {
        List<Bitmap> images = new ArrayList<>();
        for (int id : imageIDs)
        {
            images.add(BitmapFactory.decodeResource(activity.getResources(), id));
        }
        return images;
    }
}
