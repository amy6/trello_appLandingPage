package com.example.android.applandingpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
//    private LinearLayout pageIndicatorLayout;
//    private int numOfPages;
//    private int[] colors = {R.color.colorOne, R.color.colorTwo, R.color.colorThree, R.color.colorFour};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.photos_viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        tabLayout.setupWithViewPager(viewPager);

        /*numOfPages = adapter.getCount();
        pageIndicatorLayout = findViewById(R.id.dotsIndicatorLayout);

        addPageIndicator(0);*/

//        viewPager.addOnPageChangeListener(pageChangeListener);

    }

    /*ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addPageIndicator(position);

//            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(position);
//            tab.setBackgroundResource(colors[position]);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


      Set different color for each page indicator

    private void addPageIndicator(int position) {

        TextView[] indicators = new TextView[numOfPages];
        pageIndicatorLayout.removeAllViews();

        for(int i=0; i<indicators.length; i++) {

            indicators[i] = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(2,2,2,2);
            indicators[i].setLayoutParams(layoutParams);
            indicators[i].setText(Html.fromHtml("&#8226;"));
            indicators[i].setTextSize(40);
            indicators[i].setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

            pageIndicatorLayout.addView(indicators[i]);
        }

        if(indicators.length > 0) {
            indicators[position].setTextColor(ContextCompat.getColor(this, colors[position]));
        }
    }*/
}
