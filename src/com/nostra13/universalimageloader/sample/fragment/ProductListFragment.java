package com.nostra13.universalimageloader.sample.fragment;

import android.app.ListFragment;
import android.os.Bundle;

import com.nostra13.universalimageloader.sample.Constants;
import com.nostra13.universalimageloader.sample.adapter.UserEndlessAdapter;
import com.nostra13.universalimageloader.sample.api.model.Product;

import java.util.ArrayList;

public class ProductListFragment extends ListFragment {
    UserEndlessAdapter adapter = null;
    private static final String[] IMAGE_URLS = Constants.IMAGES;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);

        if (adapter == null) {
            ArrayList<Product> items = new ArrayList<Product>();

            for (int i = 0; i < 25; i++) {
                Product newProduct = new Product(IMAGE_URLS[i], "Title", "Desc");
                items.add(newProduct);
            }

            adapter = new UserEndlessAdapter(getActivity(), items);
        }

        setListAdapter(adapter);
    }
}
