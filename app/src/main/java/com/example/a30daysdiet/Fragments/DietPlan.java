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

import org.w3c.dom.Text;


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
            selectButton(tv30Days,tvSetWater,tvShopping);
        });

        tvSetWater.setOnClickListener(view2 -> {
            viewPager.setCurrentItem(1);
            selectButton(tvSetWater,tvShopping,tv30Days);
        });

        tvShopping.setOnClickListener(view3 -> {
            viewPager.setCurrentItem(2);
            selectButton(tvShopping,tv30Days,tvSetWater);
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
                    return new DaysFragment();
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
    private void selectButton(TextView textView1, TextView textView2, TextView textView3)
    {
        textView1.setBackgroundResource(R.color.app_color);
        textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.white));
        textView2.setBackgroundResource(R.drawable.button_background_selected);
        textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.app_color));
        textView3.setBackgroundResource(R.drawable.button_background_selected);
        textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.app_color));
    }
}