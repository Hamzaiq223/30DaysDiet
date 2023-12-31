package com.example.a30daysdiet.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a30daysdiet.R;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ViewHolder> {
    private List<String> data;
    DayClick dayClick;

    public DaysAdapter(List<String> data,DayClick dayClick) {
        this.data = data;
        this.dayClick = dayClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.rv_days_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = data.get(position);

        holder.tvDays.setText(String.format("%s",item));

        holder.cvDay.setOnClickListener(view -> {
            dayClick.onDayClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDays;
        private CardView cvDay;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDays = itemView.findViewById(R.id.tvDays);
            cvDay = itemView.findViewById(R.id.cvDay);
        }


    }
    public interface DayClick{
        void onDayClick(String Day);
    }
}
