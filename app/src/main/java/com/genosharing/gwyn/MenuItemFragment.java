package com.genosharing.gwyn;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Blackrental on 07.12.2016.
 */

public class MenuItemFragment extends Fragment {

    public final static String ARG_MENU_ITEM_NUMBER = "itemNumber";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (EnumMenuItem.ENTDECKEN.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            View view = inflater.inflate(R.layout.result_list, container, false);
//            ResultListArrayAdapter adapter = new ResultListArrayAdapter(getContext(),
//                    R.layout.single_result, DummyData.getOffers(getActivity()));

//            ListView listView = (ListView) view.findViewById(R.id.results);
//            listView.setAdapter(adapter);
            return view;
        }
        if (EnumMenuItem.KATEGORIEN.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.PROFIL.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.IMPRESSUM.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        if (EnumMenuItem.HILFE.equals(savedInstanceState.get(ARG_MENU_ITEM_NUMBER)))
        {
            return inflater.inflate(R.layout.result_list, container, false);
        }
        return inflater.inflate(R.layout.result_list, container, false);
    }
}