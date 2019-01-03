package com.example.azizx.completeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.azizx.completeapp.R;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("productName");
        String desc = intent.getStringExtra("productDescription");


        Toast.makeText(getApplicationContext(), "ProductName is: " + name, Toast.LENGTH_LONG).show();

    }
}
