package com.laboratorio.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listadatos;
    ArrayList<Datos> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listadatos = (ListView) findViewById(R.id.lsdatos);
        Lista = new ArrayList<Datos>();
        Lista.add(new Datos(1, "Asma", "El asma es una enfermedad crónica que afecta las vías respiratorias, causando inflamación y estrechamiento de los conductos de aire.", R.drawable.dbs_1));
        Lista.add(new Datos(2, "Enfermedad pulmonar obstructiva crónica", "La EPOC es una enfermedad progresiva que obstruye las vías respiratorias y dificulta la respiración.", R.drawable.dbs_2));
        Lista.add(new Datos(3, "Neumonía", "La neumonía es una infección que inflama los sacos de aire en uno o ambos pulmones.", R.drawable.dbs_3));
        Lista.add(new Datos(4, "Tuberculosis", "La tuberculosis es una enfermedad infecciosa causada por la bacteria Mycobacterium tuberculosis.", R.drawable.dbs_4));
        Lista.add(new Datos(5, "Fibrosis pulmonar", "La fibrosis pulmonar es una enfermedad crónica en la cual los tejidos de los pulmones se vuelven cicatrizados y gruesos, lo que dificulta la respiración.", R.drawable.dbs_5));
        Lista.add(new Datos(6, "Enfermedad pulmonar intersticial", "Esta es una categoría de enfermedades pulmonares que afectan los tejidos y espacios intersticiales de los pulmones.", R.drawable.dbs_6));
        Lista.add(new Datos(7, "Enfermedad del legionario", " La enfermedad del legionario es una forma grave de neumonía causada por la bacteria Legionella pneumophila.", R.drawable.dbs_7));
        Lista.add(new Datos(8, "Enfermedad pulmonar obstructiva del sueño", "La EPOS es una afección en la cual las vías respiratorias se obstruyen repetidamente durante el sueño, lo que resulta en episodios de interrupción de la respiración.", R.drawable.dbs_8));
        Adaptador miadaptador = new Adaptador(getApplicationContext(), Lista);
        listadatos.setAdapter(miadaptador);
    }
}