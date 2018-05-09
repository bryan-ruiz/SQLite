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

public class InsertarOrden extends AppCompatActivity {

    EditText codigoOrden, codigoPlato, fecha, hora, comentario;
    Button insertar;
    ListView listView;
    ArrayList<String> lista;
    ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_orden);
        codigoOrden = (EditText) findViewById(R.id.codigoOrden);
        codigoPlato = (EditText) findViewById(R.id.codigoPlato);
        fecha = (EditText) findViewById(R.id.fecha);
        hora = (EditText) findViewById(R.id.hora);
        comentario = (EditText) findViewById(R.id.comentario);
        insertar = (Button) findViewById(R.id.buttonInsertar);
        /*listView = (ListView) findViewById(R.id.listView);
        lista = new ArrayList<String>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adaptador);*/
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        Orden orden = new Orden(codigoOrden.getText().toString(),codigoPlato.getText().toString(),fecha.getText().toString(),hora.getText().toString(),comentario.getText().toString());
        long newRowId = orden.insertar(getApplicationContext());
        // Mostrar un mensaje para el usuario
        Toast.makeText(getApplicationContext(), "Insertardo", Toast.LENGTH_LONG).show();
    }

    /*private void leerEstudiante() {
        // Instancia la clase Estudiante y realiza la lectura de datos
        Estudiante estudiante = new Estudiante();
        // leer el estudiante, se le pasa como parametro el contexto de la app y ls identificacion
        estudiante.leer(getApplicationContext(), "1-1000-1000");
        // si lee al estudiante
        if (estudiante.getTipo().equals(Persona.TIPO_ESTUDIANTE)) {
            // Mostrar un mensaje para el usuario
            Toast.makeText(getApplicationContext(), "Leer Estudiante: " +
                    estudiante.getIdentificacion() +
                    " Carnet: " + estudiante.getCarnet() + " Nombre: " +
                    estudiante.getNombre() +
                    " " + estudiante.getPrimerApellido() + " " +
                    estudiante.getSegundoApellido() +
                    " Correo: " + estudiante.getCorreo() + " Tipo: " +
                    estudiante.getTipo() + " Promedio: " +
                    estudiante.getPromedioPonderado(), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "No hay datos para: " + "1-1000-1000", Toast.LENGTH_LONG).show();
        }
    }*/
}
