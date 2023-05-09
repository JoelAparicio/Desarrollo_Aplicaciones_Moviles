package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class resultado extends AppCompatActivity {
    TextView score1, score2, score3, score4, score5, score6, score7;
    TextView pos1, pos2, pos3, pos4, pos5, pos6, pos7;

    TextView firstFinalist, secondFinalist, thirdFinalist;
    TextView firstScore, secondScore, thirdScore;
    TextView fp, sp, tp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent resultado = getIntent();
        int[] scores = resultado.getIntArrayExtra("scores");

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

        for (int i = 0; i < scores.length; i++) {

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


        // RANKINGS

        String[] names = {"Ana Li", "Juan Pérez", "Leo Kim", "Luz Wong", "Max Kao", "Mia Wu", "Dan Chen"};

        firstFinalist = findViewById(R.id.firstFinalist);
        secondFinalist = findViewById(R.id.secondFinalist);
        thirdFinalist = findViewById(R.id.thirdFinalist);

        firstScore = findViewById(R.id.firstScore);
        secondScore = findViewById(R.id.secondScore);
        thirdScore = findViewById(R.id.thirdScore);

        fp = findViewById(R.id.fp);
        sp = findViewById(R.id.sp);
        tp = findViewById(R.id.tp);

        TextView[] scoreArray = new TextView[3];
        scoreArray[0] = firstScore;
        scoreArray[1] = secondScore;
        scoreArray[2] = thirdScore;

        TextView[] nameArray = new TextView[3];
        nameArray[0] = firstFinalist;
        nameArray[1] = secondFinalist;
        nameArray[2] = thirdFinalist;

        TextView[] positionArray = new TextView[3];
        positionArray[0] = fp;
        positionArray[1] = sp;
        positionArray[2] = tp;

        int firstIndex = -1;
        int secondIndex = -1;
        int thirdIndex = -1;
        int fourthIndex = -1;

        for (int i = 0; i < scores.length; i++) {
            int currentValue = scores[i];

            if (firstIndex == -1 || currentValue > scores[firstIndex]) {
                fourthIndex = thirdIndex;
                thirdIndex = secondIndex;
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (secondIndex == -1 || currentValue > scores[secondIndex]) {
                fourthIndex = thirdIndex;
                thirdIndex = secondIndex;
                secondIndex = i;
            } else if (thirdIndex == -1 || currentValue > scores[thirdIndex]) {
                fourthIndex = thirdIndex;
                thirdIndex = i;
            } else if (fourthIndex == -1 || currentValue > scores[fourthIndex]) {
                fourthIndex = i;
            }
        }

        String[] positions = {"1er lugar", "2do lugar", "3er lugar"};

        scoreArray[0].setText(String.valueOf(scores[firstIndex]));
        scoreArray[1].setText(String.valueOf(scores[secondIndex]));
        scoreArray[2].setText(String.valueOf(scores[thirdIndex]));

        nameArray[0].setText(names[firstIndex]);
        nameArray[1].setText(names[secondIndex]);
        nameArray[2].setText(names[thirdIndex]);

        if (scores[firstIndex] == scores[secondIndex] && scores[secondIndex] == scores[thirdIndex]) {
            positions[0] = "Empatado por 1er lugar";
            positions[1] = "Empatado por 1er lugar";
            positions[2] = "Empatado por 1er lugar";
        } else if (scores[firstIndex] == scores[secondIndex]) {
            positions[0] = "Empatado por 1er lugar";
            positions[1] = "Empatado por 1er lugar";
            positions[2] = "3er lugar";
        } else if (scores[secondIndex] == scores[thirdIndex]) {
            positions[0] = "1er lugar";
            positions[1] = "Empatado por 2do lugar";
            positions[2] = "Empatado por 2do lugar";
        } else if (scores[thirdIndex] == scores[fourthIndex]) {
            positions[0] = "1er lugar";
            positions[1] = "2do lugar";
            positions[2] = "Empatado por 3ero con finalista N°"+(fourthIndex + 1);
        } else {
            positions[0] = "1er lugar";
            positions[1] = "2do lugar";
            positions[2] = "3er lugar";
        }

        positionArray[0].setText(positions[0]);
        positionArray[1].setText(positions[1]);
        positionArray[2].setText(positions[2]);


        // RESUMEN FINAL

        TextView[] scoresArray = new TextView[7];
        scoresArray[0] = pos1;
        scoresArray[1] = pos2;
        scoresArray[2] = pos3;
        scoresArray[3] = pos4;
        scoresArray[4] = pos5;
        scoresArray[5] = pos6;
        scoresArray[6] = pos7;

        String[] posiciones = {"1er lugar", "2do lugar", "3er lugar", "4to lugar", "5to lugar", "6to lugar", "7mo lugar"};

        HashMap<Integer, List<Integer>> participantes = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (!participantes.containsKey(score)) {
                participantes.put(score, new ArrayList<Integer>());
            }
            participantes.get(score).add(i);
        }

        Arrays.sort(scores);

        for (int i = 0; i < scores.length; i++) {
            int puntaje = scores[scores.length - i - 1];
            String lugar;
            if (participantes.get(puntaje).size() > 1) {
                lugar = "Empate";
            } else {
                int posicion = participantes.get(puntaje).get(0);
                lugar = posiciones[i];
                scoresArray[posicion].setText(lugar);
            }
            for (int j : participantes.get(puntaje)) {
                if (j != i) {
                    scoresArray[j].setText(lugar);
                }
            }
        }

    }
}