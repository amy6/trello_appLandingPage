package com.example.android.applandingpage;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

import static android.view.Gravity.BOTTOM;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.END;
import static android.view.Gravity.RIGHT;
import static android.view.Gravity.START;
import static android.view.Gravity.TOP;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by mahima on 22/3/18.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private TabLayout tabLayout;
    private LayoutInflater inflater;
    private int[] layouts = {R.layout.fragment_one, R.layout.fragment_two, R.layout.fragment_three,
            R.layout.fragment_four};
    private int[] tabIndicatorColors = {R.color.colorFramgentOne, R.color.colorFragmentTwo, R.color.colorFragmentThree, R.color.colorFramentFour};

    public ImageSliderAdapter(Context context, TabLayout tabLayout) {
        this.context = context;
        this.tabLayout = tabLayout;
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
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<View> viewArrayList = new ArrayList<>();

        for(int i=0; i<layouts.length ; i++) {
            View view = inflater.inflate(layouts[i], container, false);
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
