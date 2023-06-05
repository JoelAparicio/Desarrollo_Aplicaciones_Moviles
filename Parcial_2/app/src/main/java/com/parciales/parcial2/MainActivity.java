package com.parciales.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private Spinner spinner1;

    private TextView tv1;
    private CheckBox check1;
    private String cliente[] = {"Regular", "Jubilado"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
        check1 = (CheckBox) findViewById(R.id.check1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cliente);
        spinner1.setAdapter(adapter);
    }

    public void calcular (View v){
        double precio = Double.parseDouble(et1.getText().toString());
        double resultado = 0.00;
        DecimalFormat df = new DecimalFormat("#.##");
        String selectedItem = spinner1.getSelectedItem().toString();

        if (selectedItem.equals("Regular")) {
            if (check1.isChecked()) {
                resultado = precio + (precio * 0.07);
                tv1.setText("Total a pagar: " + df.format(resultado));
            } else {
                resultado = precio;
                tv1.setText("Total a pagar: " + df.format(resultado));
            }
        } else {
            if (check1.isChecked()) {
                resultado = precio - (precio * 0.2) + (precio * 0.07);
                tv1.setText("Total a pagar: " + df.format(resultado));
            } else {
                resultado = precio - (precio * 0.2);
                tv1.setText("Total a pagar: " + df.format(resultado));
            }
        }



    }
}