package com.laboratorio.laboratorio12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;



public class MainActivity extends AppCompatActivity {
    EditText et_nombre;
    EditText et_correo;
    Button guardar;
    Button borrar;
    Button actualizar;
    Button adelante;
    Button atras;
    Cursor c;
    AlertDialog.Builder alertDialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = (EditText) findViewById(R.id.et1);
        et_correo = (EditText) findViewById(R.id.et2);

        //definir los controles que estan en el main.xml
        guardar = (Button) findViewById(R.id.bt_insert);
        borrar = (Button) findViewById(R.id.bt_delete);
        actualizar = (Button) findViewById(R.id.bt_update);

        adelante = (Button) findViewById(R.id.bt_adelante);
        atras = (Button) findViewById(R.id.bt_atras);

        //Abrir la bd en modo escritura
        ClaseSQLiteBD1 csql = new ClaseSQLiteBD1(this, "Estudiantes.db", null, 1);
        final SQLiteDatabase db = csql.getWritableDatabase();

        //creando un cursor para obtener los datos de la BD
        c = db.rawQuery("select * from contacto", null);

        //declaracion del proveedor de contenidos
        final ContentValues nuevoRegistro = new ContentValues();
        alertDialogBuilder = new AlertDialog.Builder(this);

        //boton guardar
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nuevoRegistro.put("nombre", et_nombre.getText().toString());
                nuevoRegistro.put("correo", et_correo.getText().toString());
                db.insert("contacto", null, nuevoRegistro);
                Toast.makeText(getApplicationContext(), "Se guardo el registro", Toast.LENGTH_SHORT).show();
                et_nombre.setText("");
                et_correo.setText("");
                c = db.rawQuery("select * from contacto", null);
            }
        });

        // Botón borrar
        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Configura el título del cuadro de diálogo
                alertDialogBuilder.setTitle("Confirmación");
                // Configura el mensaje del cuadro de diálogo
                alertDialogBuilder.setMessage("¿Está seguro de eliminar el registro?");
                alertDialogBuilder.setCancelable(false);

                // Configura el botón "Sí" del cuadro de diálogo
                alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String ID = String.valueOf(c.getInt(0));
                        db.delete("contacto", "_id=?", new String[]{ID});
                        et_nombre.setText("");
                        et_correo.setText("");

                        Context context = getApplicationContext();
                        CharSequence text = "REGISTRO ELIMINADO";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        c = db.rawQuery("select * from contacto", null);
                    }
                });

                // Configura el botón "No" del cuadro de diálogo
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                }).create().show();
            }
        });

        // Actualizar
        actualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Configura el título del cuadro de diálogo
                alertDialogBuilder.setTitle("Confirmación");
                // Configura el mensaje del cuadro de diálogo
                alertDialogBuilder.setMessage("¿Está seguro de actualizar el registro?");
                alertDialogBuilder.setCancelable(false);

                // Configura el botón "Sí" del cuadro de diálogo
                alertDialogBuilder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ContentValues nuevoRegistro = new ContentValues();
                        nuevoRegistro.put("NOMBRE", et_nombre.getText().toString());
                        nuevoRegistro.put("CORREO", et_correo.getText().toString());
                        String ID = String.valueOf(c.getInt(0));
                        int cant = db.update("contacto", nuevoRegistro, "_id = ?", new String[]{ID});

                        if (cant == 1) {
                            Toast.makeText(getApplicationContext(), "Se modificaron los datos", Toast.LENGTH_SHORT).show();
                            c = db.rawQuery("select * from contacto", null);
                            et_nombre.setText("");
                            et_correo.setText("");
                        } else {
                            Toast.makeText(getApplicationContext(), "No existe un contacto con dicho documento", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Configura el botón "No" del cuadro de diálogo
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
            }
        });

// Botón Atrás
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    // Mueve el cursor una posición hacia atrás
                    c.moveToPrevious();
                    et_nombre.setText(c.getString(1));
                    et_correo.setText(c.getString(2));
                } catch (Exception e) {
                    c.moveToLast();
                    et_nombre.setText(c.getString(1));
                    et_correo.setText(c.getString(2));
                }
            }
        });

// Botón Adelante
        adelante.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    // Mueve el cursor una posición hacia adelante
                    c.moveToNext();
                    et_nombre.setText(c.getString(1));
                    et_correo.setText(c.getString(2));
                } catch (Exception e) {
                    c.moveToFirst();
                    et_nombre.setText(c.getString(1));
                    et_correo.setText(c.getString(2));
                }
            }
        });

    }
}