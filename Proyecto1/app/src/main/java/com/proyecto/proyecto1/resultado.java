package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class resultado extends AppCompatActivity {
    TextView score1, score2, score3, score4, score5, score6, score7;
    TextView pos1, pos2, pos3, pos4, pos5, pos6, pos7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score4);
        score5 = findViewById(R.id.score5);
        score6 = findViewById(R.id.score6);
        score7 = findViewById(R.id.score7);

        pos1 = findViewById(R.id.pos1);
        pos2 = findViewById(R.id.pos2);
        pos3 = findViewById(R.id.pos3);
        pos4 = findViewById(R.id.pos4);
        pos5 = findViewById(R.id.pos5);
        pos6 = findViewById(R.id.pos6);
        pos7 = findViewById(R.id.pos7);

        Intent resultado = getIntent();
        int[] scores = resultado.getIntArrayExtra("scores");
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        String puntaje;

        for (int i = 0; i < scores.length; i++) {
//            Toast.makeText(this, "test "+i, Toast.LENGTH_SHORT).show();
            if (i == 0) {
                score1.setText(String.valueOf(scores[i]));
            }
            else if (i == 1) {
                score2.setText(String.valueOf(scores[i]));
            }
            else if (i == 2) {
                score3.setText(String.valueOf(scores[i]));
            }
            else if (i == 3) {
                score4.setText(String.valueOf(scores[i]));
            }
            else if (i == 4) {
                score5.setText(String.valueOf(scores[i]));
            }
            else if (i == 5) {
                score6.setText(String.valueOf(scores[i]));
            }
            else if (i == 6) {
                score7.setText(String.valueOf(scores[i]));
            }
        }


        // HMMMMMMMMMMM


    }
}