package com.jks.amal.TypesOfCancers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterTypes extends FragmentStateAdapter {


    public ViewPagerAdapterTypes(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new WomenFragment();
            case 2:
                return new ChildrenFragment();
        }
        return new MenFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
