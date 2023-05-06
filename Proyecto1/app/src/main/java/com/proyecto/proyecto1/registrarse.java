package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        Intent intent = getIntent();




    }

    public void entrar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}