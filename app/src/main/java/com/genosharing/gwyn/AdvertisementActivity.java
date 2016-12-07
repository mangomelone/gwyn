package com.genosharing.gwyn;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Sweet on 06.12.16.
 */
public class AdvertisementActivity extends Activity {

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


    }

    public void showResults(View view)
    {
        Intent intent = new Intent(this, NavigatorActivity.class);
        startActivity(intent);
    }

}
