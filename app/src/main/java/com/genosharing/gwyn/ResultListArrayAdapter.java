package com.genosharing.gwyn;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
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

        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.single_result, null);
        }

        ImageView image = (ImageView) view.findViewById(R.id.single_result_image);
        image.setImageBitmap(offer.getProduct().getImage());
        TextView title = (TextView) view.findViewById(R.id.single_result_title);
        title.setText(offer.getProduct().getName());
        TextView price = (TextView) view.findViewById(R.id.single_result_price);
        price.setText(offer.getPrice().toString());
        ImageView profilePic = (ImageView) view.findViewById(R.id.single_result_profile_pic);
        profilePic.setImageBitmap(offer.getVendor().getProfilePic());
        RatingBar rating = (RatingBar) view.findViewById(R.id.ratingBar);
        rating.setRating(offer.getVendor().getRating().getValue());
        return view;
    }
}
