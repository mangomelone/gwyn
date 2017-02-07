package com.genosharing.gwyn.fragments.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.genosharing.gwyn.data.DummyData;
import com.genosharing.gwyn.activities.NavigatorActivity;
import com.genosharing.gwyn.fragments.DetailFragment;
import com.genosharing.gwyn.fragments.MenuItemFragment;
import com.genosharing.gwyn.model.Offer;
import com.genosharing.gwyn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corinna on 26.01.2017.
 */

public class ErgebnisseFragment extends MenuItemFragment {

    private List<String> suchworte;
    private List<Offer> offers = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_list, container, false);

        offers = getOffers();

        ResultListArrayAdapter adapter = new ResultListArrayAdapter(getActivity(),
                R.layout.single_result, offers);

        ListView listView = (ListView) view.findViewById(R.id.results);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Offer detail = (Offer) parent.getItemAtPosition(position);
                NavigatorActivity activity = (NavigatorActivity) getActivity();
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setAngebot(detail);
                activity.navigateTo(detailFragment);
            }
        });
        return view;
    }

    @Override
    public String getBezeichnung() {
        return "Suchergebnisse";
    }

    public List<String> getSuchworte() {
        return suchworte;
    }

    public void setSuchworte(List<String> suchworte) {
        this.suchworte = suchworte;
    }

    public List<Offer> getOffers() {
        for (String suchwort : suchworte)
        {
            for (Offer offer : DummyData.getOffers(getActivity()))
            {
                if (!offers.contains(offer))
                {
                    boolean addOffer = false;
                    if (tagsMatch(suchwort, offer.getProduct().getName()))
                    {
                        addOffer = true;
                    }
                    else {
                        for (String tag : offer.getProduct().getTags())
                        {
                            if (tagsMatch(suchwort, tag))
                            {
                                addOffer = true;
                                break;
                            }
                        }
                    }
                    if (addOffer)
                        offers.add(offer);
                }
            }
        }
        return offers;
    }

    private boolean tagsMatch(String tag1, String tag2)
    {
        return tag1.toLowerCase().contains(tag2.toLowerCase()) || tag2.toLowerCase().contains(tag1.toLowerCase());
    }
}
