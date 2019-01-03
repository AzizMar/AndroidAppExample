package com.example.azizx.completeapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azizx.completeapp.Activities.HomeActivity;
import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.models.User;

import java.util.Map;

import static com.example.azizx.completeapp.Activities.MainActivity.sharedPreferences;
import static com.example.azizx.completeapp.Activities.MainActivity.sharedPreferencesEditor;
import static com.example.azizx.completeapp.Activities.MainActivity.users;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    Button loginSubmit;
    TextView nameTxt, passwordTxt;
    Map<String, ?> mySavedPrefs;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        // Init fragment components
        nameTxt = v.findViewById(R.id.nameText);
        passwordTxt = v.findViewById(R.id.passwordText);
        loginSubmit = v.findViewById(R.id.submitLoginButton);

        // Retrieving saved userName and password if exists
        mySavedPrefs = sharedPreferences.getAll();
        if (mySavedPrefs.containsKey("userName") && mySavedPrefs.containsKey("password")) {
            nameTxt.setText(sharedPreferences.getString("userName", "defaultValue"));
            passwordTxt.setText(sharedPreferences.getString("password", "defaultValue"));

        }

        // Submit ActionListener
        loginSubmit.setOnClickListener(view -> authUser());

        return v;
    }


    // Helper function.
    private void authUser() {

        //creating new user from login form fields
        User u = new User();
        u.name = nameTxt.getText().toString();
        u.password = passwordTxt.getText().toString();

        // TODO retrieve user from DB instead of List
        // Checking if user exists in Database (list called users).
        if (users.contains(u)) {

            // Saving userName and password in shared preferences when authenticated
            // sharedPreferences & sharedPreferencesEditor are static variables defined in MainActivity
            sharedPreferencesEditor.putString("userName", u.name);
            sharedPreferencesEditor.putString("password", u.password);
            sharedPreferencesEditor.commit();

            Toast.makeText(getActivity(), "Login success!", Toast.LENGTH_LONG).show();

            // Redirect authenticated user to HomeActivity along with userName
            // use getApplicationContext()when calling from a normal activity
            // use getActivity() when calling from a fragment
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("name", u.name);
            startActivity(intent);


        } else {
            Toast.makeText(getActivity(), "Wrong credentials!", Toast.LENGTH_LONG).show();
        }
    }

}
