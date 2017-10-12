package com.example.chris.contactodb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chris on 11/10/2017.
 */

public class MiSQLiteOpenHelper extends SQLiteOpenHelper{

    public static final String  TABLE_CONTACTOS_NAME="contactos";
    public static final String[] COLUMNS_NAME_TABLE_CONTACTOS = {"id", "nombre","correo_electronico"
            , "twitter","telefono","fecha_nacimiento"};
    private static final int VERSION_DB = 1;

    private  final String SCRIPT_TABLE_CONTACTOS="create table " + TABLE_CONTACTOS_NAME + "(" +
            COLUMNS_NAME_TABLE_CONTACTOS[0] + " integer primary key autoincrement, " +
            COLUMNS_NAME_TABLE_CONTACTOS[1] + " varchar(100) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[2] + " varchar(200) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[3] + " varchar(100) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[4] + " varchar(20) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[5] + " varchar(20) not null " +
            ");";

    public MiSQLiteOpenHelper(Context contexto){
        super(contexto, "miBD", null, VERSION_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCRIPT_TABLE_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
