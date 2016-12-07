package com.genosharing.gwyn;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hackathon on 06.12.16.
 */
public class ResultListArrayAdapter extends ArrayAdapter {

    public ResultListArrayAdapter(Context context, @LayoutRes int resource, @NonNull List<Offer> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Offer offer = (Offer) getItem(position);
        ImageView image = (ImageView) convertView.findViewById(R.id.single_result_image);
        image.setImageResource(R.mipmap.ic_launcher);
        TextView title = (TextView) convertView.findViewById(R.id.single_result_title);
        title.setText(offer.getProduct().getName());
        TextView price = (TextView) convertView.findViewById(R.id.single_result_price);
        title.setText(offer.getPrice().toString());
        return convertView;
    }
}
