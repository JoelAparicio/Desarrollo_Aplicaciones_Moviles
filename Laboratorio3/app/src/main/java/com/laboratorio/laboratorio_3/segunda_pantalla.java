package com.laboratorio.laboratorio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class segunda_pantalla extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        tv1 = (TextView) findViewById(R.id.tv1);

        Intent intent = getIntent();
        String area = intent.getStringExtra("area");
        tv1.setText("El area es: " + area);

    }
}