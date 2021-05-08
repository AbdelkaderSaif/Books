package com.example.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentAbout extends Fragment {
    Button b1;

    public FragmentAbout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_about, container, false);
        b1 = v.findViewById(R.id.BtnAbout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOne fragmentOne= new FragmentOne();
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.FGMain,fragmentOne);
                transaction.commit();


            }
        });
        return  v;

    }
}