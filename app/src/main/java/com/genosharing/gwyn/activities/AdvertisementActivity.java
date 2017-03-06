package com.genosharing.gwyn.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.genosharing.gwyn.R;
import com.genosharing.gwyn.ViewPagerAdapter;
import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.fragments.DetailFragment;
import com.genosharing.gwyn.fragments.result.ErgebnisseFragment;
import com.genosharing.gwyn.model.Offer;

import java.util.List;

/**
 * Created by Sweet on 06.12.16.
 */
public class AdvertisementActivity extends Activity {

    private List<Offer> amBestenBewertet;

    private List<Offer> amHäufigstenVerliehen;

    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;
    private EditText sucher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.slogan);
        Bitmap resizedSlogan = Bitmap.createScaledBitmap(bm, (int) (bm.getWidth() * 0.75), (int) (bm.getHeight() * 0.75), true);
        ImageView sloganImage = (ImageView) findViewById(R.id.imageView);
        sloganImage.setImageBitmap(resizedSlogan);

        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        Bitmap resized = Bitmap.createScaledBitmap(bm2, (int) (bm2.getWidth() * 0.6), (int) (bm2.getHeight() * 0.6), true);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImageView);
        logoImage.setImageBitmap(resized);

        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.btnfinden);
        Bitmap resizedBtn = Bitmap.createScaledBitmap(bm3, (int) (bm3.getWidth() * 0.5), (int) (bm3.getHeight() * 0.5), true);
        ImageView buttonImage = (ImageView) findViewById(R.id.btnimageView);
        buttonImage.setImageBitmap(resizedBtn);

        sucher = (EditText) findViewById(R.id.input_suche);

        //ViewPager intro_images = (ViewPager) findViewById(R.id.pager_introduction);
        //btnNext = (ImageButton) findViewById(R.id.btn_next);
        //btnFinish = (ImageButton) findViewById(R.id.btn_finish);

        //LinearLayout pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        //btnNext.setOnClickListener(this);
        //btnFinish.setOnClickListener(this);

        //mAdapter = new ViewPagerAdapter(AdvertisementActivity.this, amBestenBewertet, this);
        //intro_images.setAdapter(mAdapter);
        //intro_images.setCurrentItem(0);
        //intro_images.setOnPageChangeListener(this);
        //setUiPageViewController();

        amHäufigstenVerliehen = DummyData.getOffers(this);
        LinearLayout linearLayoutEntliehen = (LinearLayout) this.findViewById(R.id.linearLayoutEntliehen);
        createScrollableOfferList(linearLayoutEntliehen, amHäufigstenVerliehen);

        amBestenBewertet = DummyData.getOffers(this);
        LinearLayout linearLayoutBewertet = (LinearLayout) this.findViewById(R.id.linearLayoutBewertet);
        createScrollableOfferList(linearLayoutBewertet, amBestenBewertet);

    }

    private void createScrollableOfferList(LinearLayout linearLayout, List<Offer> offers) {
        for (final Offer offer : offers)
        {
            ImageView tempImageView = new ImageView(this);
            Bitmap scaledBitmap = offer.getProduct().getImages().get(0);
            scaledBitmap=Bitmap.createScaledBitmap(scaledBitmap, (int) 200, (int) 200, true);
            tempImageView.setImageBitmap(scaledBitmap);
            tempImageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            tempImageView.setPadding(40, 0, 40, 0);
            tempImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showOffer(offer);
                }
            });
            linearLayout.addView(tempImageView);
        }
    }


    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    public void showOffer(Offer offer)
    {
        Intent intent = new Intent(this, NavigatorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Fragment", DetailFragment.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void showResults(View view)
    {
        Intent intent = new Intent(this, NavigatorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Fragment", ErgebnisseFragment.class);
        bundle.putString("Suchtext", sucher.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
