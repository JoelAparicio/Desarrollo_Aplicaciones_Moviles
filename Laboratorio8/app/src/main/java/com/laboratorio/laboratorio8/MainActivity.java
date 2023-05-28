package com.laboratorio.laboratorio8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1, tv2;
    private String cedula = "";
    private String fecha = "";
    private String nuevo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

    }

    public void guardar (View v){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        cedula = et1.getText().toString();
        fecha = et2.getText().toString();
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("cedula", cedula);
        editor.putString("fecha", fecha);
        editor.commit();
        Toast.makeText(this, "Los datos han sido guardados", Toast.LENGTH_SHORT).show();
    }

    public void recuperar (View v){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        cedula = preferencias.getString("cedula", "No existe Cedula!");
        fecha = preferencias.getString("fecha", "No existe Fecha!");
        et1.setText(cedula);
        et2.setText(fecha);
    }

    public void borrar (View v){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        Toast.makeText(this, "Referencias borradas", Toast.LENGTH_SHORT).show();
        editor.commit();
    }

    public void actualizar (View v){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        cedula = et1.getText().toString();
        fecha = et2.getText().toString();
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("cedula", cedula);
        editor.putString("fecha", fecha);
        editor.commit();
        Toast.makeText(this, "Los datos han sido actualizados", Toast.LENGTH_SHORT).show();
    }


}