package com.example.azizx.completeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azizx.completeapp.R;
import com.example.azizx.completeapp.models.User;

import static com.example.azizx.completeapp.Activities.MainActivity.users;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    Button registerSubmit;
    TextView nameTxt, passwordTxt, password2Txt;

    public RegisterFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        registerSubmit = view.findViewById(R.id.submitRegisterButton);
        nameTxt = view.findViewById(R.id.nameText);
        passwordTxt = view.findViewById(R.id.passwordText);
        password2Txt = view.findViewById(R.id.password2Text);

        clickActions();

        return view;

    }


    private void clickActions() {
        registerSubmit.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        User u = new User();
        u.name = nameTxt.getText().toString();
        u.password = passwordTxt.getText().toString();
        if (users.add(u)) {
            Toast.makeText(getActivity(), "User registered sucessfully!" + " Total users = " + users.size(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "problem registering users", Toast.LENGTH_LONG).show();
        }


    }




}
