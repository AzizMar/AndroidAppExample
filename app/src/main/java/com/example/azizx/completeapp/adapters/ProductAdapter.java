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
import com.example.azizx.completeapp.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
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
                    R.layout.product_item, parent, false
            );
        }

        // brandImageRow & brandTextRow from brand_spinner_adapter layout
        ImageView productImage = convertView.findViewById(R.id.prodImage);
        TextView productName = convertView.findViewById(R.id.prodName);
        TextView productDescription = convertView.findViewById(R.id.prodDesc);

        Product currentItem = getItem(position);

        if (currentItem != null) {
            productImage.setImageResource(currentItem.productImg);
            productName.setText(currentItem.productName);
            productDescription.setText(currentItem.description);
        }

        return convertView;
    }
}