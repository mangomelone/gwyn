package com.genosharing.gwyn.data;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.genosharing.gwyn.R;
import com.genosharing.gwyn.model.Accessory;
import com.genosharing.gwyn.model.Availability;
import com.genosharing.gwyn.model.Offer;
import com.genosharing.gwyn.model.Price;
import com.genosharing.gwyn.model.PriceUnit;
import com.genosharing.gwyn.model.Rent;
import com.genosharing.gwyn.model.Product;
import com.genosharing.gwyn.model.Rating;
import com.genosharing.gwyn.model.User;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hackathon on 06.12.16.
 */
public class DummyData {

    public static final String BELIEBT = "beliebt";
    public static final String MEISTVERLIEHEN = "meistverliehen";
    private static List<Offer> offers;

    private static final double SCALE = 0.5;
    private static final double PROFILE_SCALE = 0.25;

    private static final Price _10Euro = new Price(BigDecimal.TEN);
    private static final Price _12Euro = new Price(BigDecimal.valueOf(12));
    private static final Price _20Euro = new Price(BigDecimal.valueOf(20));

    private static final Rent _10EuroProTag = new Rent(_10Euro, PriceUnit.DAY);
    private static final Rent _12EuroProTag = new Rent(_12Euro, PriceUnit.DAY);
    private static final Rent _18EuroProTag = new Rent(new Price(BigDecimal.valueOf(18)), PriceUnit.DAY);
    private static final Rent _20EuroProWoche = new Rent(_20Euro, PriceUnit.WEEK);
    private static final Rent _25EuroProTag = new Rent(new Price(BigDecimal.valueOf(25)), PriceUnit.DAY);
    private static final Rent _29EuroProTag = new Rent(new Price(BigDecimal.valueOf(29)), PriceUnit.DAY);
    private static final Rent _39EuroProTag = new Rent(new Price(BigDecimal.valueOf(39)), PriceUnit.DAY);
    private static final Rent _599EuroProWoche = new Rent(new Price(BigDecimal.valueOf(599)), PriceUnit.WEEK);

    public static List<Offer> getOffers(Activity activity) {

        if (offers != null)
        {
            return offers;
        }

        offers = new ArrayList<>();

        List<String> huepfburgTags = new ArrayList<>();
        huepfburgTags.add("Hüpfburg");
        huepfburgTags.add("Freizeit");
        huepfburgTags.add("Kinder");
        huepfburgTags.add("Spaß");

        Product tesla = new Product("Tesla", activity.getString(R.string.desc_tesla),
                createImages(activity, R.drawable.tesla_gif), createTags(BELIEBT, "Auto", "Fahrzeug", "Modern", "Elektro"));

        Product partykuehlschrank = new Product("Edelstahl-Partykühlschrank", activity.getString(R.string.desc_partykuehlschrank),
                createImages(activity, R.drawable.partykuehlschrank), createTags(MEISTVERLIEHEN, "Fest", "Feier", "Getränke"));

        Product karaokemaschine = new Product("Karaokemaschine", activity.getString(R.string.desc_karaoke),
                createImages(activity, R.drawable.karaokebox), createTags(MEISTVERLIEHEN, "Singen", "Freunde", "Stimmung", "Spaß"));

        Product snowboard = new Product("Snowboard Salomon", activity.getString(R.string.desc_snowboard),
                createImages(activity, R.drawable.snowboard_gif), createTags(MEISTVERLIEHEN, "Schnee", "Winter", "Urlaub", "Fahren"));


        Product bohrmaschine = new Product("Metabo Bohrmaschine SEB1000", activity.getString(R.string.desc_bohrmaschine),
                createImages(activity, R.drawable.schlagbohrmaschine_bild1, R.drawable.schlagbohrmaschine_bild2, R.drawable.schlagbohrmaschine_bild3, R.drawable.bohrmaschine2, R.drawable.bohrmaschine3, R.drawable.bohrmaschine4, R.drawable.bohrmaschine5, R.drawable.bohrmaschine6),
                createTags(MEISTVERLIEHEN, "Handwerk", "Werkzeug"));

        Product xbox = new Product("Xbox One S", activity.getString(R.string.desc_xbox),
                createImages(activity, R.drawable.x_box), createTags(BELIEBT, "Konsole", "Spiele"));

        Product unterwasserkamera = new Product("Key Mission 170", activity.getString(R.string.desc_unterwasserkamera),
                createImages(activity, R.drawable.unterwasserkamera), createTags(BELIEBT, "Fotografie", "Equipment", "Urlaub", "Reise"));

        Product htcvive  = new Product("HTC Vive", activity.getString(R.string.desc_vive),
                createImages(activity, R.drawable.htc_vive), createTags(BELIEBT, "Virtual Reality"));

        Product zapfanlage = new Product("Bierzapfanlage", activity.getString(R.string.desc_zapfanlage),
                createImages(activity, R.drawable.zapfanlage), createTags(MEISTVERLIEHEN, "Feier", "Fest", "Getränke"));

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

        List<String> includes = createIncludes("Gute Stimmung", "Spaß", "Hilfestellungen bei der Nutzung", "Anleitung");

        List<Accessory> zubehoer1 = createAccessories("Sonnenbrille", "Navigationsgerät");

        List<Accessory> zubehoer2 = createAccessories("20er Pack Energiedrinks", "1 Kiste Bier");

        List<Accessory> zubehoer3 = createAccessories("Halsbonbons", "Ohrstöpsel");

        List<Accessory> zubehoer4 = createAccessories("Helm", "Getönte Skibrille");

        List<Accessory> zubehoer5 = createAccessories("Steinbohrer Set", "Metallbohrer Set", "Holzbohrer Set");

        List<Accessory> zubehoer6 = createAccessories("2ter Wireless Controller", "Spiel Halo 5", "Spiel Fifa17");

        List<Accessory> zubehoer7 = createAccessories("Taucherbrille", "Schnorchel", "Flossen");

        List<Accessory> zubehoer8 = createAccessories("Gaming PC", "4K Monitor", "Brillenputztücher");

        List<Accessory> zubehoer9 = createAccessories("10 Liter Fass Pils", "Pilsgläser", "Bierdeckel");

        List<Accessory> zubehoerHuepf = createAccessories("Pumpe", "Ganz viel Spaß");

        DateTime now = new DateTime();
        Availability availability = new Availability(new Interval(now, now.plusYears(2)), new ArrayList<DateTime>());

        Offer offer1 = new Offer(tesla, includes, zubehoer1,  _599EuroProWoche, verkaeufer1, availability);
        Offer offer2 = new Offer(partykuehlschrank, includes, zubehoer2,  _20EuroProWoche, verkaeufer3, availability);
        Offer offer3 = new Offer(karaokemaschine, includes, zubehoer3,  _10EuroProTag, verkaeufer2, availability);
        Offer offer4 = new Offer(snowboard, includes, zubehoer4,  _25EuroProTag, verkaeufer2, availability);
        Offer offer5 = new Offer(bohrmaschine, includes, zubehoer5,  _10EuroProTag, verkaeufer2, availability);
        Offer offer6 = new Offer(xbox, includes, zubehoer6,  _29EuroProTag, verkaeufer2, availability);
        Offer offer7 = new Offer(unterwasserkamera, includes, zubehoer7,  _18EuroProTag, verkaeufer2, availability);
        Offer offer8 = new Offer(htcvive, includes, zubehoer8,  _39EuroProTag, verkaeufer2, availability);
        Offer offer9 = new Offer(zapfanlage, includes, zubehoer9,  _18EuroProTag, verkaeufer2, availability);
        Offer offer10 = new Offer(huepfburg, includes, zubehoerHuepf,  _20EuroProWoche, verkaeufer1, availability);
        Offer offer11 = new Offer(huepfinsel, includes, zubehoerHuepf,  _20EuroProWoche, verkaeufer3, availability);
        Offer offer12 = new Offer(huepfhaus, includes, zubehoerHuepf,  _10EuroProTag, verkaeufer2, availability);

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

    private static List<String> createTags(String... tags)
    {
        List<String> tagList = new ArrayList<>();
        for (String tag : tags)
        {
            tagList.add(tag);
        }
        return tagList;
    }

    private static List<String> createIncludes(String... includes)
    {
        List<String> toBeIncluded = new ArrayList<>();
        for (String include : includes)
        {
            toBeIncluded.add(include);
        }
        return  toBeIncluded;
    }

    private static List<Accessory> createAccessories(String... accessories)
    {
        List<Price> prices = new ArrayList<>();
        prices.add(_10Euro);
        prices.add(_12Euro);
        prices.add(_20Euro);
        List<Accessory> accessoryList = new ArrayList<>();
        for (int i = 0; i < accessories.length; i++)
        {
            accessoryList.add(new Accessory(accessories[i], prices.get(i % prices.size())));
        }
        return accessoryList;
    }
}
