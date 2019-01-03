package com.example.azizx.completeapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.models.Brand;

import java.util.ArrayList;

public class BrandAdapter extends ArrayAdapter<Brand> {

    public BrandAdapter(Context context, ArrayList<Brand> brandArrayList) {
        super(context, 0, brandArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.brand_spinner_row, parent, false
            );
        }

        // brandImageRow & brandTextRow from brand_spinner_adapter layout
        ImageView brandImage = convertView.findViewById(R.id.brandImgRow);
        TextView brandText = convertView.findViewById(R.id.brandTextRow);

        Brand currentItem = getItem(position);

        if (currentItem != null) {
            brandImage.setImageResource(currentItem.brandImage);
            brandText.setText(currentItem.brandName);
        }

        return convertView;
    }
}