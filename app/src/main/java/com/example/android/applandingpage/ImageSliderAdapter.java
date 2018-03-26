package com.example.android.applandingpage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

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
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<View> viewArrayList = new ArrayList<>();

        for (int layout : layouts) {

            if (inflater != null) {
                View view = inflater.inflate(layout, container, false);
                viewArrayList.add(view);
                container.addView(view);

                switch (position) {
                    case 2:
                        final ImageView imageView = view.findViewById(R.id.trello_taco_img);
                        if (imageView != null) {
                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    YoYo.with(Techniques.StandUp)
                                            .duration(2000)
                                            .playOn(imageView);
                                }
                            });
                        }
                        break;
                    case 3:
                        ImageView playStoreImg = view.findViewById(R.id.playstore);
                        ImageView appStoreImg = view.findViewById(R.id.appstore);
                        final Intent intent = new Intent(Intent.ACTION_VIEW);

                        if(playStoreImg != null) {
                            playStoreImg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        context.startActivity(intent.setData(Uri.parse("market://details?id=" +
                                                context.getString(R.string.playstore_ID))));
                                    } catch (ActivityNotFoundException exception) {
                                        context.startActivity(intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" +
                                                context.getString(R.string.playstore_ID))));
                                    }
                                }
                            });
                        }

                        if(appStoreImg != null) {
                            appStoreImg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        context.startActivity(intent.setData(Uri.parse("itms-apps://itunes.apple.com/app/id" +
                                                context.getString(R.string.applestore_ID))));
                                    } catch (ActivityNotFoundException exception) {
                                        context.startActivity(intent.setData(Uri.parse("https://itunes.apple.com/app/id" +
                                                context.getString(R.string.applestore_ID))));
                                    }
                                }
                            });
                        }
                        break;
                }
            }
        }

        return viewArrayList.get(position);

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView) object);
    }
}
