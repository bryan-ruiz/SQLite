package com.example.bryan.labbasedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bryan on 28/4/2017.
 */

public class Insumo {
    private String codigoPlato, codigoInsumo, nombreInsumo, cantidadInsumo, unidadMedidaInsumo;

    public Insumo(String codigoPlato, String codigoInsumo, String nombreInsumo, String cantidadInsumo, String unidadMedidaInsumo) {
        this.codigoPlato = codigoPlato;
        this.codigoInsumo = codigoInsumo;
        this.nombreInsumo = nombreInsumo;
        this.cantidadInsumo = cantidadInsumo;
        this.unidadMedidaInsumo = unidadMedidaInsumo;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(String cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public String getUnidadMedidaInsumo() {
        return unidadMedidaInsumo;
    }

    public void setUnidadMedidaInsumo(String unidadMedidaInsumo) {
        this.unidadMedidaInsumo = unidadMedidaInsumo;
    }

    public long insertar(Context context) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO, getCodigoInsumo());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_INSUMO, getNombreInsumo());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_CANTIDAD_INSUMO, getCantidadInsumo());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_UNIDAD_INSUMO, getUnidadMedidaInsumo());
        // Insertar la nueva fila

        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_INSUMO, null, values);
    }

    public void leer (Context context, String codigo){
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_INSUMO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_CANTIDAD_INSUMO,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_UNIDAD_INSUMO,
        };

        // Filtro para el WHERE
        String selection = DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO + " = ?";
        String[] selectionArgs = {codigo};
        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_INSUMO, // tabla
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
            setCodigoInsumo(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO)));
            setNombreInsumo(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE_INSUMO)));
            setCantidadInsumo(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_CANTIDAD_INSUMO)));
            setUnidadMedidaInsumo(cursor.getString(cursor.getColumnIndexOrThrow(
                    DataBaseContract.DataBaseEntry.COLUMN_NAME_UNIDAD_INSUMO)));
        }
    }
}
