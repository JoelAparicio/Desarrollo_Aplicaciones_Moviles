package com.laboratorio.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void calculo (View view){
        float base = Float.parseFloat(edt1.getText().toString());
        float altura = Float.parseFloat(edt2.getText().toString());
        if (base <= 0 || altura <= 0){
            Toast.makeText(this, "Los valores deben ser mayores a 0", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            float area = (base * altura) / 2;
            DecimalFormat df = new DecimalFormat("#.##");
            String resultado = df.format(area);

            tv1.setText("El area es: " + resultado);
        }
    }
}