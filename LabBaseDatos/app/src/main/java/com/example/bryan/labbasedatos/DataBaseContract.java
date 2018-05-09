package com.example.bryan.labbasedatos;

import android.provider.BaseColumns;

/**
 * Created by Bryan on 28/4/2017.
 */

public class DataBaseContract {
    // Implementa la interfaz BaseColumns para heredar campos estandar del marco de Android _ID

    public static class DataBaseEntry implements BaseColumns {

        // Clase Orden

        public static final String TABLE_NAME_ORDEN = "Orden";
        public static final String COLUMN_NAME_CODIGO_ORDEN = "codigoOrden";
        //public static final String COLUMN_NAME_CODIGO_PLATO = "codigoPlato";
        public static final String COLUMN_NAME_FECHA = "fecha";
        public static final String COLUMN_NAME_HORA = "hora";
        public static final String COLUMN_NAME_COMENTARIO = "comentario";

        public static final String TABLE_NAME_PLATO = "plato";
        //public static final String COLUMN_NAME_CODIGO_PLATO = "codigoPlato";
        public static final String COLUMN_NAME_NOMBRE_PLATO = "nombrePlato";
        public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
        public static final String COLUMN_NAME_PRECIO = "precio";

        public static final String TABLE_NAME_INSUMO_PLATO = "insumoPlato";
        //public static final String COLUMN_NAME_CODIGO_INSUMO = "codigoInsumo";
        public static final String COLUMN_NAME_CODIGO_PLATO = "codigoPlato";

        public static final String TABLE_NAME_INSUMO = "insumo";
        public static final String COLUMN_NAME_CODIGO_INSUMO = "codigoInsumo";
        public static final String COLUMN_NAME_NOMBRE_INSUMO = "nombreInsumo";
        public static final String COLUMN_NAME_CANTIDAD_INSUMO = "cantidadInsumo";
        public static final String COLUMN_NAME_UNIDAD_INSUMO = "unidadMedidaInsumo";

    }

// Construir las tablas de la base de datos

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String REAL_TYPE = " REAL";

    private static final String COMMA_SEP = ",";


    // Creacion de tablas

    public static final String SQL_CREATE_ORDEN =

            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_ORDEN + " (" +

                    DataBaseEntry.COLUMN_NAME_CODIGO_ORDEN + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_FECHA + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_HORA + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_COMENTARIO + TEXT_TYPE + COMMA_SEP +

                    "FOREIGN KEY(" + DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + ") REFERENCES " +

                        DataBaseEntry.TABLE_NAME_PLATO + "(" + DataBaseEntry.COLUMN_NAME_CODIGO_PLATO +"))";


    public static final String SQL_DELETE_ORDEN =

            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_ORDEN;


    public static final String SQL_CREATE_PLATO =

            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_PLATO + " (" +

                    DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_NOMBRE_PLATO + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_DESCRIPCION + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_PRECIO + TEXT_TYPE + ")";

    public static final String SQL_DELETE_PLATO =

            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_PLATO;

    public static final String SQL_CREATE_INSUMO_PLATO =

            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_INSUMO_PLATO + " (" +

                    DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + TEXT_TYPE + COMMA_SEP +

                    "FOREIGN KEY(" + DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO + ") REFERENCES " +

                    DataBaseEntry.TABLE_NAME_INSUMO + "(" + DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO +

                    ")"+ COMMA_SEP +

                    "FOREIGN KEY(" + DataBaseEntry.COLUMN_NAME_CODIGO_PLATO + ") REFERENCES " +

                    DataBaseEntry.TABLE_NAME_PLATO + "(" + DataBaseEntry.COLUMN_NAME_CODIGO_PLATO +

                    "))";


    public static final String SQL_DELETE_INSUMO_PLATO  =

            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_INSUMO_PLATO;

    public static final String SQL_CREATE_INSUMO =

            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_INSUMO + " (" +

                    DataBaseEntry.COLUMN_NAME_CODIGO_INSUMO + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_NOMBRE_INSUMO + TEXT_TYPE + COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_CANTIDAD_INSUMO + TEXT_TYPE +COMMA_SEP +

                    DataBaseEntry.COLUMN_NAME_UNIDAD_INSUMO + TEXT_TYPE + ")";

    public static final String SQL_DELETE_INSUMO =

            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_INSUMO;
}
