package com.nostra13.universalimageloader.sample.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.commonsware.cwac.endless.EndlessAdapter;
import com.nostra13.universalimageloader.sample.Constants;
import com.nostra13.universalimageloader.sample.R;
import com.nostra13.universalimageloader.sample.api.model.Product;

import java.util.ArrayList;

public class UserEndlessAdapter extends EndlessAdapter {
   // private RotateAnimation rotate = null;
    private View pendingView = null;

    public UserEndlessAdapter(Context ctxt, ArrayList<Product> list) {
        super(new UserListAdapter(ctxt,
                R.layout.list_item_new,
                list));
//        rotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF,
//                0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f);
//        rotate.setDuration(600);
//        rotate.setRepeatMode(Animation.RESTART);
//        rotate.setRepeatCount(Animation.INFINITE);
    }

    @Override
    protected View getPendingView(ViewGroup parent) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        pendingView = row.findViewById(android.R.id.text1);
        pendingView.setVisibility(View.GONE);
        pendingView = row.findViewById(R.id.throbber);
        pendingView.setVisibility(View.VISIBLE);
//        startProgressAnimation();

        return (row);
    }

    @Override
    protected boolean cacheInBackground() {
        SystemClock.sleep(10000);       // pretend to do work

        return (getWrappedAdapter().getCount() < 1000);
    }

    @Override
    protected void appendCachedData() {
        if (getWrappedAdapter().getCount() < 1000) {
            @SuppressWarnings("unchecked")
            UserListAdapter adapter = (UserListAdapter )getWrappedAdapter();

            for (int i = 0; i < 25; i++) {
                Product newUser = new Product(Constants.IMAGES[i], "Title", "Desc");
                adapter.add(newUser);
            }
        }
    }

//    public void startProgressAnimation() {
//        if (pendingView != null) {
//           // pendingView.startAnimation(rotate);
//        }
//    }


}