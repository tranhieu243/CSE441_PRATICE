package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    //Nhận dữ liệu truyền từ ngoài vào
    private List<Country> countries;

    public CountryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.img_flag.setImageResource(country.getFlag());
        holder.txt_countryName.setText(country.getCountryName());
        holder.txt_countryCapital.setText(country.getCountryCapital());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //Định nghĩa ViewHolder
    class CountryViewHolder extends RecyclerView.ViewHolder{
        ImageView img_flag;
        TextView txt_countryName;
        TextView txt_countryCapital;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            img_flag = itemView.findViewById(R.id.img_flag);
            txt_countryName = itemView.findViewById(R.id.txt_countryName);
            txt_countryCapital = itemView.findViewById(R.id.txt_countryCapital);

        }
    }
}
