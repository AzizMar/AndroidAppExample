package com.example.azizx.completeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.adapters.ProductAdapter;
import com.example.azizx.completeapp.models.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ProductAdapter pAdapter;
    private ListView productsListView;
    private ArrayList<Product> products = new ArrayList<>();
    private String selectedBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Intent intent = getIntent();
        String selectedBrand = intent.getStringExtra("selectedBrand");


        switch (selectedBrand) {
            case "Asus":
                initAsusProducts();
                break;
            case "Hp":
                initHpProducts();
                break;
        }

        // Setting listView

        productsListView = findViewById(R.id.productListVIew);
        pAdapter = new ProductAdapter(getApplicationContext(), products);
        productsListView.setAdapter(pAdapter);

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get clicked product information and send then to productDetailsActivity with intent
                Product clickedProduct = (Product) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra("productImage", clickedProduct.productImg);
                intent.putExtra("productName", clickedProduct.productName);
                intent.putExtra("productDescription", clickedProduct.description);
                startActivity(intent);

            }
        });

    }


    private void initAsusProducts() {
        products.add(new Product("Laptop rog", R.drawable.asus, "Laptop with i7 7500HQ processor, 8GB Ram, 500GB HDD"));
        products.add(new Product("Laptop strix", R.drawable.asus, "Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
        products.add(new Product("Notebook", R.drawable.asus, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC"));
        products.add(new Product("keyboard", R.drawable.asus, "ut the majority have suffered alteration in some form, by injected humour, or randomised words which"));
        products.add(new Product("Smart Phone", R.drawable.asus, "irst true generator on the Internet. It uses a dictionary of over 200 Latin words, combine"));
    }

    private void initHpProducts() {
        products.add(new Product("Inspiron 2511", R.drawable.hp, "Laptop with i7 7500HQ processor, 8GB Ram, 500GB HDD"));
        products.add(new Product("Smart watch", R.drawable.hp, "Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
        products.add(new Product("Dumb watch", R.drawable.hp, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC"));
        products.add(new Product("Hpiron", R.drawable.hp, "ut the majority have suffered alteration in some form, by injected humour, or randomised words which"));
        products.add(new Product("Smart Phone", R.drawable.hp, "irst true generator on the Internet. It uses a dictionary of over 200 Latin words, combine"));
    }

}
