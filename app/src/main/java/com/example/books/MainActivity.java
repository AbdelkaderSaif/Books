package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button BtnRegister,BtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnRegister= findViewById(R.id.BtnMainRegister);
        BtnLogin = findViewById(R.id.BtnLogin);

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              OpenRegister();
            }
        });

    }

    public void OpenRegister(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
    public  void OpenLogin(View view){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
    

}