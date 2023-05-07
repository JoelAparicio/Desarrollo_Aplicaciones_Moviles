package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class votacion extends AppCompatActivity {

    private TextView part1, part2, part3, part4, part5, part6, part7;
    private RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7;
    int select = 0;
//    int[] finalscores = {0, 0, 0, 0, 0, 0, 0};

    // TESTING ONLY
    int[] finalscores = {3, 6, 12, 15, 18, 21, 24};
    // TESTING ONLY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);

        part1 = findViewById(R.id.part1);
        part2 = findViewById(R.id.part2);
        part3 = findViewById(R.id.part3);
        part4 = findViewById(R.id.part4);
        part5 = findViewById(R.id.part5);
        part6 = findViewById(R.id.part6);
        part7 = findViewById(R.id.part7);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);

        String pending = "Pendiente por votación";
        part1.setText(pending);
        part2.setText(pending);
        part3.setText(pending);
        part4.setText(pending);
        part5.setText(pending);
        part6.setText(pending);
        part7.setText(pending);

        // TESTING ONLY
        for (int i = 0; i < finalscores.length; i++) {
//            Toast.makeText(this, "test "+i, Toast.LENGTH_SHORT).show();

            if (i == 0) {
                part1.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 1) {
                part2.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 2) {
                part3.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 3) {
                part4.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 4) {
                part5.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 5) {
                part6.setText(String.valueOf(finalscores[i]));
            }
            else if (i == 6) {
                part7.setText(String.valueOf(finalscores[i]));
            }

        }
        // TESTING ONLY


    }

//    public void radio (View v) {
//        boolean checked = ((RadioButton) v).isChecked();
//
//        if (v.getId() == R.id.radio1) {
//            if (checked) {
//                select = 1;
//            }
//        }
//        else if (v.getId() == R.id.radio2) {
//            if (checked) {
//                select = 2;
//            }
//        }
//        else if (v.getId() == R.id.radio3) {
//            if (checked) {
//                select = 3;
//            }
//        }
//        else {
//            select = 0;
//        }
//
//        String message = "Ha seleccionado al finalista N°"+select;
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }

    public void radio1 (View v) {
        select = 1;
    }
    public void radio2 (View v) {
        select = 2;
    }
    public void radio3 (View v) {
        select = 3;
    }
    public void radio4 (View v) {
        select = 4;
    }
    public void radio5 (View v) {
        select = 5;
    }
    public void radio6 (View v) {
        select = 6;
    }
    public void radio7 (View v) {
        select = 7;
    }

    public void evaluate (View v) {
        Intent votacion = new Intent(this, finalista.class);

        if (select == 0) {
            Toast.makeText(this, "Por favor seleccione un finalista.", Toast.LENGTH_LONG).show();
        }
        else {
//            if (radio1.isChecked()) {
//                votacion.putExtra("id", select);
//            }
//            else if (radio2.isChecked()) {
//                votacion.putExtra("id", select);
//            }
//            else if (radio3.isChecked()) {
//                votacion.putExtra("id", select);
//            }

            votacion.putExtra("id", select);
            startActivityForResult(votacion, 50);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 50) && (resultCode == RESULT_OK)){
            Toast.makeText(this, "Finalista N°"+select+" evaluado.", Toast.LENGTH_SHORT).show();

            int score = data.getIntExtra("part", 0);
            String puntaje = String.valueOf(score);
            if (select == 1) {
                finalscores[0] = score;
                part1.setText(puntaje);
            }
            else if (select == 2) {
                finalscores[1] = score;
                part2.setText(puntaje);
            }
            else if (select == 3) {
                finalscores[2] = score;
                part3.setText(puntaje);
            }
            else if (select == 4) {
                finalscores[3] = score;
                part4.setText(puntaje);
            }
            else if (select == 5) {
                finalscores[4] = score;
                part5.setText(puntaje);
            }
            else if (select == 6) {
                finalscores[5] = score;
                part6.setText(puntaje);
            }
            else if (select == 7) {
                finalscores[6] = score;
                part7.setText(puntaje);
            }

        }
    }

    public void finalize (View v) {

        boolean missing = false;

        for (int i = 0; i < finalscores.length; i++) {
            if (finalscores[i] == 0) {
                missing = true;
                break;
            }
        }

        if (missing) {
            Toast.makeText(this, "Por favor evalúe a todos los finalistas.", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, resultado.class);
            intent.putExtra("scores", finalscores);
            startActivity(intent);
        }
    }
}