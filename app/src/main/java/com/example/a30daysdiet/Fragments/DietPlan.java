package com.example.a30daysdiet.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a30daysdiet.R;


public class DietPlan extends Fragment {

     ViewPager viewPager;
     ViewPagerAdapter viewPagerAdapter;

     TextView tv30Days,tvSetWater,tvShopping;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        tv30Days = view.findViewById(R.id.tvDays);
        tvSetWater = view.findViewById(R.id.tvWater);
        tvShopping = view.findViewById(R.id.tvShopping);

        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        // Set click listeners and other logic here

        tv30Days.setOnClickListener(view1 -> {
            viewPager.setCurrentItem(0);
            tv30Days.setBackgroundResource(R.color.app_color);
            tv30Days.setTextColor(ContextCompat.getColor(requireContext(),R.color.white));
        });

        tvSetWater.setOnClickListener(view2 -> {
            viewPager.setCurrentItem(1);
            tvSetWater.setBackgroundResource(R.color.app_color);
            tvSetWater.setTextColor(ContextCompat.getColor(requireContext(),R.color.white));
        });

        tvShopping.setOnClickListener(view3 -> {
            viewPager.setCurrentItem(2);
            tvShopping.setBackgroundResource(R.color.app_color);
            tvShopping.setTextColor(ContextCompat.getColor(requireContext(),R.color.white));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diet_plan, container, false);
    }
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private static final int NUM_FRAGMENTS = 3;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Days();
                case 1:
                    return new Water();
                case 2:
                    return new Shopping();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_FRAGMENTS;
        }
    }

}