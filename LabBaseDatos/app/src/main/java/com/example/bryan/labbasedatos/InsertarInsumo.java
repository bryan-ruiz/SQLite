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

public class InsertarInsumo extends AppCompatActivity {

    EditText codigoInsumo, nombreInsumo, cantidadInsumo, unidadMedidaInsumo,codigoPlato;
    Button insertar, eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_insumo);
        codigoPlato = (EditText) findViewById(R.id.codigoPlato);
        codigoInsumo = (EditText) findViewById(R.id.codigoInsumo);
        nombreInsumo = (EditText) findViewById(R.id.nombreInsumo);
        cantidadInsumo = (EditText) findViewById(R.id.cantidadInsumo);
        unidadMedidaInsumo = (EditText) findViewById(R.id.unidadMedidaInsumo);
        insertar = (Button) findViewById(R.id.buttonInsertar);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarInsumo();
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

    private void insertarInsumoPlato() {
        InsumoPlato insumoPlato = new InsumoPlato(codigoInsumo.getText().toString(), codigoPlato.getText().toString());
        long newRowId = insumoPlato.insertar(getApplicationContext());
        // Mostrar un mensaje para el usuario
        Toast.makeText(getApplicationContext(), "Insertardo InsumoPlato", Toast.LENGTH_LONG).show();
    }

    private void insertarInsumo() {
        Insumo insumo = new Insumo(codigoPlato.getText().toString(),codigoInsumo.getText().toString(),nombreInsumo.getText().toString(),cantidadInsumo.getText().toString(),unidadMedidaInsumo.getText().toString());
        long newRowId = insumo.insertar(getApplicationContext());
        // Mostrar un mensaje para el usuario
        Toast.makeText(getApplicationContext(), "Insertardo Insumo", Toast.LENGTH_LONG).show();
        insertarInsumoPlato();
    }

}
