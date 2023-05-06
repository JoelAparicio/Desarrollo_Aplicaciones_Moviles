package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registrarse extends AppCompatActivity {
    private EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        Intent registrarse = getIntent();


    }

    public void registrarse(View v){
        Intent registro = new Intent(this, MainActivity.class);
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);

        registro.putExtra("usuario", usuario.getText().toString());
        registro.putExtra("password", password.getText().toString());

        startActivity(registro);
    }
}