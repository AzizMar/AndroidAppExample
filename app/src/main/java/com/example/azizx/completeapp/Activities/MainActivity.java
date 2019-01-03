package com.example.azizx.completeapp.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.fragments.LoginFragment;
import com.example.azizx.completeapp.fragments.RegisterFragment;
import com.example.azizx.completeapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> users = new ArrayList<>();
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;

    // Defining View components.
    Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        // Calling Defined functions.
        initViews();
        clickActions();
        showFragment(new LoginFragment());

    }

    //###################################//
    //--------- DEFINITIONS ------------//
    //#################################//

    public void initViews() {
        loginBtn = findViewById(R.id.LoginButton);
        registerBtn = findViewById(R.id.RegisterButton);
    }

    private void showFragment(Fragment frag) {
        //int x = R.id.fragmentContainer;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, frag).commit();
    }

    public void clickActions() {
        loginBtn.setOnClickListener(view -> showFragment(new LoginFragment()));
        registerBtn.setOnClickListener(view -> showFragment(new RegisterFragment()));


    }
}
