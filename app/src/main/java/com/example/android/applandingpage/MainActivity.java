package com.example.android.applandingpage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = findViewById(R.id.photos_viewpager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, tabLayout);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        tabLayout.setupWithViewPager(viewPager);

    }

    public void tacoClick(View view) {
        YoYo.with(Techniques.StandUp)
                .duration(2000)
                .playOn(view);
    }

    public void getTheApp(View view) {
        int id = view.getId();
        Intent intent = new Intent(Intent.ACTION_VIEW);

        switch (id) {
            case R.id.playstore:
                try{
                    startActivity(intent.setData(Uri.parse("market://details?id=" + getString(R.string.playstore_ID))));
                }
                catch (ActivityNotFoundException exception) {
                    startActivity(intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getString(R.string.playstore_ID))));
                }
                break;

            case R.id.appstore:
                try{
                    startActivity(intent.setData(Uri.parse("itms-apps://itunes.apple.com/app/id" + getString(R.string.applestore_ID))));
                }
                catch (ActivityNotFoundException exception) {
                    startActivity(intent.setData(Uri.parse("https://itunes.apple.com/app/id" + getString(R.string.applestore_ID))));
                }

                break;
        }
    }
}
