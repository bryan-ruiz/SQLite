package com.example.bryan.labbasedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 28/4/2017.
 */

public class Orden {
    private String codigoOrden, codigoPlato, fecha, hora, comentario;

    public Orden(String codigoOrden, String codigoPlato, String fecha, String hora, String comentario) {
        this.codigoOrden = codigoOrden;
        this.codigoPlato = codigoPlato;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long insertar(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_ORDEN, getCodigoOrden());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO, getCodigoPlato());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_FECHA, getFecha());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_HORA, getHora());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_COMENTARIO, getComentario());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_ORDEN, null, values);
    }


}
