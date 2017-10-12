package com.example.chris.contactodb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/10/2017.
 */

public class DaoContacto {
    Context contexto;
    SQLiteDatabase midb;

    public DaoContacto(Context contexto){
        this.contexto = contexto;
        this.midb = new MiSQLiteOpenHelper(contexto).getWritableDatabase();
    }

    public long insert(Contacto c){
        ContentValues cv = new ContentValues();

        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[1], c.getUsuario());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[2], c.getEmail());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[3], c.getTw());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[4], c.getTel());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[5], c.getFechaN());

        return  midb.insert(MiSQLiteOpenHelper.TABLE_CONTACTOS_NAME,null,cv);
    }

    public ArrayList<Contacto> getAll(){
        ArrayList<Contacto> lstC=null;

        Cursor cursor = midb.query(MiSQLiteOpenHelper.TABLE_CONTACTOS_NAME,
                MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS,
                null, null, null,null,null);


        if(cursor.moveToFirst()){
            lstC = new ArrayList<>();
            do{
                Contacto c = new Contacto();

                c.setUsuario(cursor.getString(1));
                c.setEmail(cursor.getString(2));
                c.setTw(cursor.getString(3));
                c.setTel(cursor.getInt(4));
                c.setFechaN(cursor.getString(5));

                lstC.add(c);

            }while (cursor.moveToNext());
        }

        return lstC;
    }

}
