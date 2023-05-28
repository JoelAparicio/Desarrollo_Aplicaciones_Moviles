package com.laboratorio.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1, v1, v2;
    private String operacion[] = {"Sumar", "Restar", "Multiplicar", "Dividir", "Elevar al cubo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        v1 = (TextView) findViewById(R.id.v1);
        v2 = (TextView) findViewById(R.id.v2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operacion);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String selectedItem = spinner1.getSelectedItem().toString();
                System.out.print(selectedItem);
                if (selectedItem.equals("Elevar al cubo")) {
                    et2.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    tv1.setText("Resultado");
                } else {
                    et2.setVisibility(View.VISIBLE);
                    v2.setVisibility(View.VISIBLE);
                    tv1.setText("Resultado");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void operar (View v){
        double num1 = Integer.parseInt(et1.getText().toString());
        double num2 = Integer.parseInt(et2.getText().toString());
        DecimalFormat df = new DecimalFormat("#.##");
        String operacion = spinner1.getSelectedItem().toString();
        if (operacion.equals("Sumar")){
            double suma = num1 + num2;
            tv1.setText("La suma es= "+df.format(suma));
        } else if (operacion.equals("Restar")){
            double resta = num1 - num2;
            tv1.setText("La resta es= "+df.format(resta));
        } else if (operacion.equals("Multiplicar")){
            double multiplicacion = num1 * num2;
            tv1.setText("La multiplicacion es= "+df.format(multiplicacion));
        } else if (operacion.equals("Dividir")){
            double division = num1 / num2;
            tv1.setText("La division es= "+df.format(division));
        } else if (operacion.equals("Elevar al cubo")){
            double cubo = Math.pow(num1, 3);
            tv1.setText("La potencia cubica es= "+df.format(cubo));
        }
    }
}