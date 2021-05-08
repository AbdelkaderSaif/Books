package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class FrMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr_main);

        FragmentAbout fragmentAbout=new FragmentAbout();
        FragmentManager fm= getSupportFragmentManager();


        fm.beginTransaction().add(R.id.FGMain,fragmentAbout).commit();
    }
}