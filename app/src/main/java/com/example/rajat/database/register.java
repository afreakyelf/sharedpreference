package com.example.rajat.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Fragment {

    EditText name,username,password;
    Button register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_register,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        name = getActivity().findViewById(R.id.name);
        username = getActivity().findViewById(R.id.username);
        password = getActivity().findViewById(R.id.password);
        register = getActivity().findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mysp1", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("username"+username.getText().toString(),username.getText().toString());
                editor.putString("password"+username.getText().toString(),password.getText().toString());
                editor.apply();

                Toast.makeText(getContext(), "Register Successfully", Toast.LENGTH_SHORT).show();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content,new login());
                ft.commit();

            }
        });


    }
}
