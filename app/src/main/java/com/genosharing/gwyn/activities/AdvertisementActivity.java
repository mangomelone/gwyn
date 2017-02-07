package com.genosharing.gwyn.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.genosharing.gwyn.R;
import com.genosharing.gwyn.ViewPagerAdapter;

/**
 * Created by Sweet on 06.12.16.
 */
public class AdvertisementActivity extends Activity {

    private int[] amBestenBewertet = {
            R.drawable.tesla,
            R.drawable.unterwasserkamera,
            R.drawable.htc_vive,
            R.drawable.karaokebox,
            R.drawable.partykuehlschrank,
            R.drawable.schlagbohrmaschine_bild1,
            R.drawable.x_box,
            R.drawable.zapfanlage
    };

    private int[] amHäufigstenVerliehen = {
            R.drawable.htc_vive,
            R.drawable.x_box,
            R.drawable.schlagbohrmaschine_bild1,
            R.drawable.tesla,
            R.drawable.zapfanlage,
            R.drawable.unterwasserkamera,
            R.drawable.karaokebox,
            R.drawable.partykuehlschrank
    };

    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;


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

        LinearLayout linearLayoutEntliehen = (LinearLayout) this.findViewById(R.id.linearLayoutEntliehen);

        for (int imageRessource : amHäufigstenVerliehen)
        {
            ImageView tempImageView2 = new ImageView(this);
            Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(), imageRessource);
            scaledBitmap=Bitmap.createScaledBitmap(scaledBitmap, (int) 200, (int) 200, true);
            tempImageView2.setImageBitmap(scaledBitmap);
            tempImageView2.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            tempImageView2.setPadding(40, 0, 40, 0);
            linearLayoutEntliehen.addView(tempImageView2);
        }

        LinearLayout linearLayoutBewertet = (LinearLayout) this.findViewById(R.id.linearLayoutBewertet);

        for (int imageRessource : amBestenBewertet)
        {
            ImageView tempImageView2 = new ImageView(this);
            Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(), imageRessource);
            scaledBitmap=Bitmap.createScaledBitmap(scaledBitmap, (int) 200, (int) 200, true);
            tempImageView2.setImageBitmap(scaledBitmap);
            tempImageView2.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            tempImageView2.setPadding(40, 0, 40, 0);
            linearLayoutBewertet.addView(tempImageView2);
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



    public void showResults(View view)
    {
        Intent intent = new Intent(this, NavigatorActivity.class);
        startActivity(intent);

    }

}
