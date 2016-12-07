package com.genosharing.gwyn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Sweet on 06.12.16.
 */
public class AdvertisementActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity);

        ImageView sloganImage = (ImageView) findViewById(R.id.imageView);
        sloganImage.setImageResource(R.drawable.slogan);
        sloganImage.bringToFront();


    }

}
