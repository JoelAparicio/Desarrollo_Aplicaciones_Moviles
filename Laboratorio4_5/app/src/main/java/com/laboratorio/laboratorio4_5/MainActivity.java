package com.laboratorio.laboratorio4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {

    private ImageView img1, img2, img3;
    private RadioButton rb1, rb2, rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);


        rb1.setOnClickListener(v -> {
            Toast.makeText(this, "Panda rojo", Toast.LENGTH_SHORT).show();
        });

        rb2.setOnClickListener(v -> {
            Toast.makeText(this, "Aguila imperial blanca", Toast.LENGTH_SHORT).show();
        });

        rb3.setOnClickListener(v -> {
            Toast.makeText(this, "Leopardo de las nieves", Toast.LENGTH_SHORT).show();
        });



    }
}