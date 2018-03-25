package com.example.android.applandingpage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;


public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private int[] layouts = {R.layout.fragment_one, R.layout.fragment_two, R.layout.fragment_three,
            R.layout.fragment_four};

    ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<View> viewArrayList = new ArrayList<>();

        for (int layout : layouts) {
            View view = null;
            if (inflater != null) {
                view = inflater.inflate(layout, container, false);
            }
            viewArrayList.add(view);
            container.addView(view);
        }

        return viewArrayList.get(position);

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView) object);
    }
}
