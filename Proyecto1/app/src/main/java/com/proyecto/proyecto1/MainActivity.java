package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends AppCompatActivity {
    private String usuario1, password1;
    private EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent registro = getIntent();

        usuario1 = registro.getStringExtra("usuario");
        password1 = registro.getStringExtra("password");


    }

    public void registrarse(View v){
        Intent registrarse = new Intent(this, registrarse.class);
        startActivityForResult(registrarse, 100);
    }

    public void entrar(View v){
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);

        // TESTING ONLY
//        usuario.setText("1234");
//        password.setText("1234");
//
//        usuario1 = "1234";
//        password1 = "1234";
        // TESTING ONLY

        if (usuario.getText().toString().equals(usuario1) && password.getText().toString().equals(password1)){
            Intent intent = new Intent(this, votacion.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Usuario o contraseña incorrectos, registrese en caso de no haberse registrado", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 100) && (resultCode == RESULT_OK)){
            usuario1 = data.getStringExtra("usuario");
            password1 = data.getStringExtra("password");
            Toast toast = Toast.makeText(this, "Usuario registrado", Toast.LENGTH_LONG);
        }
    }
}