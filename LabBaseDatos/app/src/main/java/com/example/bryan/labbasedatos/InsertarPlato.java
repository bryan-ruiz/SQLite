package com.example.bryan.labbasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertarPlato extends AppCompatActivity {
    EditText codigoPlato, nombrePlato, descripcion, precio;
    Button insertar, eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_plato);
        codigoPlato = (EditText) findViewById(R.id.codigoPlato);
        nombrePlato = (EditText) findViewById(R.id.nombrePlato);
        descripcion = (EditText) findViewById(R.id.descripcion);
        precio = (EditText) findViewById(R.id.precio);
        insertar = (Button) findViewById(R.id.buttonInsertar);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Insertardoooo", Toast.LENGTH_LONG).show();
                insertar();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void insertar() {
        Plato plato = new Plato(codigoPlato.getText().toString(),nombrePlato.getText().toString(),descripcion.getText().toString(),precio.getText().toString());
        long newRowId = plato.insertar(getApplicationContext());
        // Mostrar un mensaje para el usuario
        Toast.makeText(getApplicationContext(), "Insertado", Toast.LENGTH_LONG).show();
    }
}
