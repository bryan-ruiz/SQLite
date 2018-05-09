package com.example.bryan.labbasedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bryan on 28/4/2017.
 */

public class InsumoPlato {
    private String codigoInsumo, codigoPlato;

    public InsumoPlato(String codigoInsumo, String codigoPlato) {
        this.codigoInsumo = codigoInsumo;
        this.codigoPlato = codigoPlato;
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public long insertar(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO, getCodigoInsumo());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_PLATO, getCodigoPlato());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_INSUMO_PLATO, null, values);
    }
}
