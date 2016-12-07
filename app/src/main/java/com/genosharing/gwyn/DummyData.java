package com.genosharing.gwyn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by hackathon on 06.12.16.
 */
public class DummyData {

    public static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();
        Price _10EuroProTag = new Price(BigDecimal.TEN, Currency.getInstance(Locale.GERMANY), "Tag");
        Price _20EuroProWoche = new Price(BigDecimal.valueOf(20), Currency.getInstance(Locale.GERMANY), "Woche");
        Product huepfburg = new Product("Hüpfburg", "Ganz wunderbare Hüpfburg", null);
        Product huepfinsel = new Product("Hüpfinsel", "Ganz wunderbare Hüpfinsel", null);
        Product huepfhaus = new Product("Hüpfhaus", "Ganz wunderbares Hüpfhaus", null);
        User verkaeufer = new User("Max", "Musterverkäufer");
        Offer offer1 = new Offer(huepfburg, _20EuroProWoche, verkaeufer);
        Offer offer2 = new Offer(huepfinsel, _20EuroProWoche, verkaeufer);
        Offer offer3 = new Offer(huepfhaus, _10EuroProTag, verkaeufer);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        return offers;
    }
}
