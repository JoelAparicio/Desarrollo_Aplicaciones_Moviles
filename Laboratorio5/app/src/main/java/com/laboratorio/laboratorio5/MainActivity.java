package com.laboratorio.laboratorio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private CheckBox check1, check2, check3, check4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);

        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);
        check3 = (CheckBox)findViewById(R.id.check3);
        check4 = (CheckBox)findViewById(R.id.check4);


    }

    public void calcular(View v){
        float pedido = 0;
        if (check1.isChecked() == true){
            pedido += 3;
        }
        if (check2.isChecked() == true){
            pedido += 4;
        }
        if (check3.isChecked() == true){
            pedido += 3.5;
        }
        if (check4.isChecked() == true){
            pedido += 1.5;
        }
        tv1.setText("El total a pagar es: " + pedido + "$");
    }
}