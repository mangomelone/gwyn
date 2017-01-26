package com.genosharing.gwyn;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sweet on 23.10.16.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    private int[] mResources3;

    public ViewPagerAdapter(Context mContext, int[] mResources3, Context context) {
        this.mContext = mContext;
        this.mResources3 = mResources3;
    }

    @Override
    public int getCount() {
        return mResources3.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewPiktogramm);

        if (mResources3[position] != 0) {

            imageView.setImageResource(mResources3[position]);
        }



        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
