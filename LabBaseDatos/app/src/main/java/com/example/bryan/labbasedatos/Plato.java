package com.example.bryan.labbasedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bryan on 28/4/2017.
 */

public class Plato {
    private String codigoPlato, nombrePlato, descripcion, precio;

    public Plato(String codigoPlato, String nombrePlato, String descripcion, String precio) {
        this.codigoPlato = codigoPlato;
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public long insertar(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO, getCodigoPlato());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_PLATO, getNombrePlato());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION, getDescripcion());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_PRECIO, getPrecio());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_PLATO, null, values);
    }

    public void leer (Context context, String codigo){
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_PLATO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_PRECIO,
        };

        // Filtro para el WHERE
        String selection = DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + " = ?";
        String[] selectionArgs = {codigo};
        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_PLATO, // tabla
                projection, // columnas
                selection, // where
                selectionArgs, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );

        // recorrer los resultados y asignarlos a la clase // aca podria implementarse un ciclo si es necesario
        System.out.println(String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst() && cursor.getCount() > 0) {
            setCodigoPlato(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO)));
            setNombrePlato(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_PLATO)));
            setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION)));
            setPrecio(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_PRECIO)));
        }
    }

    public void eliminar (Context context, String codigo){
        // usar la clase DataBaseHelper para realizar la operacion de eliminar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Define el where para el borrado
        String selection = DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + " LIKE ?";
        // Se detallan los argumentos
        String[] selectionArgs = {codigo};
        // Realiza el SQL de borrado
        db.delete(DataBaseContract.DataBaseEntry.TABLE_NAME_PLATO, selection, selectionArgs);
    }
}
