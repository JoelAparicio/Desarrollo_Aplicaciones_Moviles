package com.laboratorio.laboratorio4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private ImageView img1, img2, img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnClickListener(v -> {
            Toast.makeText(this, "Panda rojo", Toast.LENGTH_SHORT).show();
        });

        img2.setOnClickListener(v -> {
            Toast.makeText(this, "Aguila imperial blanca", Toast.LENGTH_SHORT).show();
        });

        img3.setOnClickListener(v -> {
            Toast.makeText(this, "Leopardo de las nieves", Toast.LENGTH_SHORT).show();
        });



    }
}