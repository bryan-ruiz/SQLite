package com.example.bryan.labbasedatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarOrdenes extends AppCompatActivity {

    ListView listView;
    ArrayList<String> lista;
    ArrayAdapter<String> adapter;
    String fila, codigoOrden, codigoPlato, fecha, hora, comentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ordenes);
        listView = (ListView) findViewById(R.id.listView);
        lista = leer(getApplicationContext());
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
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

    public ArrayList<String> leer (Context context){
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_ORDEN,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_FECHA,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_HORA,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_COMENTARIO
        };

        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_ORDEN, // tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );
        ArrayList<String> lista = new ArrayList<String>();
        if (cursor.moveToFirst()){
            codigoOrden = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_ORDEN));
            codigoPlato = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO));
            fecha = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_FECHA));
            hora = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_HORA));
            comentario = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_COMENTARIO));
            fila = codigoOrden + ", " + codigoPlato + ", " + fecha + ", " + hora +  ", " + comentario;
            lista.add(fila);
            while(cursor.moveToNext()){
                codigoOrden = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_ORDEN));
                codigoPlato = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO));
                fecha = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_FECHA));
                hora = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_HORA));
                comentario = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_COMENTARIO));
                fila = codigoOrden + ", " + codigoPlato + ", " + fecha + ", " + hora +  ", " + comentario;
                lista.add(fila);
            }
        }
        return lista;
    }



}
