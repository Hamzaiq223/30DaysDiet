package com.example.a30daysdiet.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a30daysdiet.Adapter.DaysAdapter;
import com.example.a30daysdiet.R;

import java.util.ArrayList;


public class DaysFragment extends Fragment implements DaysAdapter.DayClick {

    private DaysAdapter daysAdapter;
    private ArrayList<String> daysList = new ArrayList<>();

    private RecyclerView rvDays;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 1 ; i<=30 ; i++ )
        {
            daysList.add(String.format("%s %s", getString(R.string.day), i));
        }

        daysAdapter = new DaysAdapter(daysList,this);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_days, container, false);
        rvDays = view.findViewById(R.id.rvDays); // Replace R.id.rvDays with the actual ID of your RecyclerView in fragment_days.xml
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3);
        rvDays.setLayoutManager(gridLayoutManager);
        rvDays.setAdapter(daysAdapter);
    }

    @Override
    public void onDayClick(String Day) {

    }
}
