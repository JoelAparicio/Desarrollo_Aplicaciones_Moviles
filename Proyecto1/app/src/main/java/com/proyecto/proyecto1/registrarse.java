package com.proyecto.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class registrarse extends AppCompatActivity {
    private EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
    }

    public void registrarse(View v){
        int longitud = password.getText().toString().length();
        String usuario = this.usuario.getText().toString();
        String password = this.password.getText().toString();
        if (usuario.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
            return;
        }
        else if (longitud > 15){
            Toast.makeText(this, "La contraseña no puede tener mas de 15 caracteres", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            Intent registro = new Intent();
            registro.putExtra("usuario", usuario);
            registro.putExtra("password", password);

            setResult(RESULT_OK, registro);
            finish();
        }

    }
}