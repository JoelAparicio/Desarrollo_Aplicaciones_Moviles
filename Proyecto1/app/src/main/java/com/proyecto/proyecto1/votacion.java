package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class votacion extends AppCompatActivity {

    private TextView part1;
    private RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7;
    int select = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);

        Intent votacion = getIntent();

        if (votacion.getStringExtra("part1") != null) {
            int score1 = Integer.parseInt(votacion.getStringExtra("part1"));
            part1.setText(score1);
        } else {
            part1.setText("Pendiente por votación");
        }

    }

    public void radio1 (View v) {
        select = 1;
    }
    public void radio2 (View v) {
        select = 2;
    }
    public void radio3 (View v) {
        select = 3;
    }

    public void evaluate (View v) {
        Intent intent = new Intent(this, finalista.class);

        boolean flag1;

        switch(select) {
            case 1:
                intent.putExtra("id", 1);
            case 2:
                intent.putExtra("id", 2);
            case 3:
                intent.putExtra("id", 3);
            default:
                flag1 = false;

        }

        if (flag1) {
            startActivity(intent);
        }
    }

//    public void finalize (View v) {
//        if () {
//
//        }
//
//        Intent intent = new Intent(this, resultados.class);
//        startActivity(intent);
//    }
}