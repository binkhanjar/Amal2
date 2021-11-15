package com.jks.amal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.jks.amal.CancerOthers.BadFood;
import com.jks.amal.CancerOthers.Detection;
import com.jks.amal.CancerOthers.GoodFood;
import com.jks.amal.CancerOthers.Prevention;
import com.jks.amal.News.NewsWHO;
import com.jks.amal.TypesOfCancers.ViewPagerAdapterTypes;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 pager2;
    ViewPagerAdapterTypes viewPagerAdapterTypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout_xml);
        pager2 = findViewById(R.id.viewpager2);


        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPagerAdapterTypes = new ViewPagerAdapterTypes(fragmentManager, getLifecycle());
        pager2.setAdapter(viewPagerAdapterTypes);

        tabLayout.addTab(tabLayout.newTab().setText("رجال"));
        tabLayout.addTab(tabLayout.newTab().setText("نساء"));
        tabLayout.addTab(tabLayout.newTab().setText("اطفال"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        // intent to prevention activity
        CardView prevention = findViewById(R.id.cv_prevention);

        prevention.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), Prevention.class));
            Toast.makeText(MainActivity.this, "الوقاية من السرطان", Toast.LENGTH_SHORT).show();
        });
        // intent to detection activity
        CardView detection = findViewById(R.id.cv_detection);

        detection.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), Detection.class));
            Toast.makeText(MainActivity.this, "الكشف المبكر", Toast.LENGTH_SHORT).show();
        });
        // intent to food good activity
        CardView foodGood = findViewById(R.id.cv_food_good);

        foodGood.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), GoodFood.class));
            Toast.makeText(MainActivity.this, "اغذية مفيدة", Toast.LENGTH_SHORT).show();
        });

        // intent to food bad activity
        CardView badGood = findViewById(R.id.cv_food_bad);

        badGood.setOnClickListener(view -> {
            startActivity(new Intent(view.getContext(), BadFood.class));
            Toast.makeText(MainActivity.this, "اغذية مضرة", Toast.LENGTH_SHORT).show();
        });

        // intent to news who activity
        CardView newswho = findViewById(R.id.cv_news_who);

        newswho.setOnClickListener(view -> startActivity(new Intent(view.getContext(), NewsWHO.class)));

        // intent to developer who activity
        CardView developer = findViewById(R.id.cv_developer);

        developer.setOnClickListener(view -> startActivity(new Intent(view.getContext(), Developer.class)));
    }
}