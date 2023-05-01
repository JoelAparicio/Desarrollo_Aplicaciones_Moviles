package com.laboratorio.laboratorio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2, edt3;
    private TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }
    public void calculo (View v){
        double var_a = Double.parseDouble(edt1.getText().toString());
        double var_b = Double.parseDouble(edt2.getText().toString());
        double var_c = Double.parseDouble(edt3.getText().toString());
        double discriminante = Math.pow(var_b, 2) - (4 * var_a * var_c);
        if (discriminante >= 0) {
            double x1 = (-var_b + Math.sqrt(discriminante)) / (2 * var_a);
            double x2 = (-var_b - Math.sqrt(discriminante)) / (2 * var_a);

            DecimalFormat df = new DecimalFormat("#.##");
            String resultado1 = df.format(x1);
            String resultado2 = df.format(x2);
            tv1.setText("X1 = " + resultado1);
            tv2.setText("X2 = " + resultado2);
        } else {
            Toast.makeText(this, "No tiene solucion", Toast.LENGTH_SHORT).show();
        }
    }
}