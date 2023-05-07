package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class votacion extends AppCompatActivity {

    private TextView part1, part2, part3, part4, part5, part6, part7;
    private RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7;
    int select = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);

        String pending = "Pendiente por votación";
        part1.setText(pending);
        part2.setText(pending);
        part3.setText(pending);
        part4.setText(pending);
        part5.setText(pending);
        part6.setText(pending);
        part7.setText(pending);

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
            startActivityForResult(intent, 50);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 50) && (resultCode == RESULT_OK)){
            switch(select) {
                case 1:
                    int score1 = Integer.parseInt(data.getStringExtra("part"));
                    part1.setText(score1);
                case 2:
                    int score2 = Integer.parseInt(data.getStringExtra("part"));
                    part2.setText(score2);
                case 3:
                    int score3 = Integer.parseInt(data.getStringExtra("part"));
                    part3.setText(score3);

            }
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