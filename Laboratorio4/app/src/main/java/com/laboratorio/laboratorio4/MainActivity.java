package com.laboratorio.laboratorio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    private TextView tv1;
    private RadioButton rb1, rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1= findViewById(R.id.edt1);
        edt2= findViewById(R.id.edt2);
        tv1= findViewById(R.id.tv1);
        rb1= findViewById(R.id.rb1);
        rb2= findViewById(R.id.rb2);
    }

    public void calcular (View v){
        String valor1= edt1.getText().toString();
        String valor2= edt2.getText().toString();
        int num1= Integer.parseInt(valor1);
        int num2= Integer.parseInt(valor2);
        if (rb1.isChecked()){
            int suma= num1+num2;
            tv1.setText("El resultad de la suma es: "+suma);
        }else if (rb2.isChecked()){
            int resta= num1-num2;

            tv1.setText("El resultado de la resta es: "+resta);
        }

    }
}