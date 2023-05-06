package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String usuario1, password1;

    private EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        usuario1 = intent.getStringExtra("usuario");
        password1 = intent.getStringExtra("password");
    }

    public void registrarse(View v){
        Intent intent = new Intent(this, registrarse.class);
        startActivity(intent);
    }

    public void entrar(View v){
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);

        if (usuario.getText().toString().equals(usuario1) && password.getText().toString().equals(password1)){
            //Intent intent = new Intent(this, menu.class);
            //startActivity(intent);
        }
        else{
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }

        
    }
}