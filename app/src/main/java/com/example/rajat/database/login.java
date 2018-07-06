package com.example.rajat.database;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class login extends Fragment {


    EditText editText,editText1;
    Button button,register;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        editText = getActivity().findViewById(R.id.username);
        editText1 = getActivity().findViewById(R.id.password);
        button = getActivity().findViewById(R.id.login);
        register = getActivity().findViewById(R.id.register);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mysp1",MODE_PRIVATE);
                String a = sharedPreferences.getString("username"+editText.getText().toString(),null);
                String b = sharedPreferences.getString("password"+editText.getText().toString(),null);

                if(TextUtils.isEmpty(editText.getText().toString())||TextUtils.isEmpty(editText1.getText().toString())){
                    Toast.makeText(getContext(), "Please fill all the fields first", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (a != null) {
                    if(a.equals(editText.getText().toString())){
                        assert b != null;
                        if(b.equals(editText1.getText().toString())){
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft= fm.beginTransaction();
                        Bundle bundle = new Bundle();
                        welcome register1 = new welcome();
                        bundle.putString("welcometext",editText.getText().toString());
                        register1.setArguments(bundle);
                        ft.replace(R.id.content,register1);
                        ft.commit();
                        }else {
                            Toast.makeText(getContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                        }

                    }
                }else {
                    Toast.makeText(getContext(), "Please register first", Toast.LENGTH_SHORT).show();
                }


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content,new register());
                ft.commit();
            }
        });


    }
}
