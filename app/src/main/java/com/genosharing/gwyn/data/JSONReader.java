package com.genosharing.gwyn.data;

import com.genosharing.gwyn.Photo;
import com.genosharing.gwyn.TagNames;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONReader {

    public static List<Photo> getHome(JSONObject jsonObject)
            throws JSONException {
        List<Photo> products = new ArrayList<Photo>();

        JSONArray jsonArray = jsonObject.getJSONArray(TagNames.TAG_PRODUCTS);
        Photo product;
        for (int i = 0; i < jsonArray.length(); i++) {
            product = new Photo();
            JSONObject productObj = jsonArray.getJSONObject(i);
            product.setId(productObj.getInt(TagNames.KEY_ID));
            product.setName(productObj.getString(TagNames.KEY_NAME));
            product.setImageUrl(productObj.getString(TagNames.KEY_IMAGE_URL));

            products.add(product);
        }
        return products;
    }
}