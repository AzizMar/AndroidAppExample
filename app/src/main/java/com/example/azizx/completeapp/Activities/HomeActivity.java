package com.example.azizx.completeapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.adapters.BrandAdapter;
import com.example.azizx.completeapp.models.Brand;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TextView helloTxt;
    public Spinner brandsSpinner;
    public ArrayList<Brand> brands;
    public BrandAdapter bAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Menu


        // Init View components
        helloTxt = findViewById(R.id.helloText);
        brandsSpinner = findViewById(R.id.spinnerBrands);
        brandsSpinner.setSelection(-1);

        // Retrieve userName passed with intent from LoginFragment
        // %s replaced with name
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        helloTxt.setText(String.format("Hello %s please choose a Brand:", name));

        // Init brands list
        initBrandsList();

        // Setting up Spinner
        bAdapter = new BrandAdapter(this, brands);
        brandsSpinner.setAdapter(bAdapter);

        brandsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Brand clickedBrand = (Brand) parent.getItemAtPosition(position);
                String clickedBrandName = clickedBrand.brandName;

                // check clicked brand name, pass it with intent to productList activity


                if (clickedBrandName.equals("Brand")) {

                    // Do nothing to avoid triggering the item selected by default

                } else {

                    Intent intent = new Intent(getApplicationContext(), ProductListActivity.class);
                    intent.putExtra("selectedBrand", clickedBrandName);
                    startActivity(intent);
                }


                Toast.makeText(getApplicationContext(), clickedBrandName, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void initBrandsList() {
        brands = new ArrayList<>();
        brands.add(new Brand("Brand", R.drawable.ic_launcher_foreground));
        brands.add(new Brand("Asus", R.drawable.asus));
        brands.add(new Brand("Hp", R.drawable.hp));
        //brands.add();
    }

    //##########################//
    // ---- Setting up Menu ---//
    //########################//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Account").setOnMenuItemClickListener(menuItem -> showToast())
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Logout")
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    private boolean showToast() {
        Toast.makeText(getApplicationContext(), "Account clicked", Toast.LENGTH_LONG).show();

        return true;
    }
}
