package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class finalista extends AppCompatActivity {

    private TextView tv1;
    private EditText eval1, eval2, eval3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalista);

        Intent finalista = getIntent();
        String finalist = finalista.getStringExtra("id");

        tv1.setText("Finalista N°"+finalist);

        eval1 = findViewById(R.id.eval1);
        eval2 = findViewById(R.id.eval2);
        eval3 = findViewById(R.id.eval3);

    }

    public void finalize (View v) {
        int content = Integer.parseInt(eval1.getText().toString());
        int projection = Integer.parseInt(eval1.getText().toString());
        int language = Integer.parseInt(eval1.getText().toString());

        if (content > 10 || content < 1) {
            Toast.makeText(this, "Las evaluaciones deben estar en el rango de 1-10.", Toast.LENGTH_LONG).show();
        }
        else if (projection > 10 || projection < 1) {
            Toast.makeText(this, "Las evaluaciones deben estar en el rango de 1-10.", Toast.LENGTH_LONG).show();
        }
        else if (language > 10 || language < 1) {
            Toast.makeText(this, "Las evaluaciones deben estar en el rango de 1-10.", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, votacion.class);
            int suma = content + projection + language;
            intent.putExtra("", suma);
            startActivity(intent);
        }

    }
}