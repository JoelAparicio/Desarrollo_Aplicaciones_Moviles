package com.laboratorio.laboratorio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.DecimalFormat;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
    }

    public void boton1 (View v){
        double radio = Double.parseDouble(edt1.getText().toString());
        double area = 4*Math.PI * Math.pow(radio, 2);

        DecimalFormat df = new DecimalFormat("#.##");
        String resultado = df.format(area);
        Intent intent = new Intent(this, segunda_pantalla.class);
        intent.putExtra("area", resultado);
        startActivity(intent);

    }
}