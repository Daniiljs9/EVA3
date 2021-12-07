package cl.inacap.campeonatopersonasdiscapacidad.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CampeonatoDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "campeonato.db";
    public static final int DB_VERSION = 1;

    public CampeonatoDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    //CREACION DE TABLA
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTxt = "CREATE TABLE JUGADOR (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOMBRE TEXT," +
                "RUT TEXT," +
                "ALTURA TEXT," +
                "PESO TEXT," +
                "EDAD INTEGER," +
                "NACIMIENTO TEXT," +
                "SEXO TEXT," +
                "CLUB TEXT," +
                "DISCAPACIDAD TEXT);";
        sqLiteDatabase.execSQL(sqlTxt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //INSERT
    public void registrarJugador(Jugador jugadores){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("NOMBRE",jugadores.getNombre());
        valores.put("RUT",jugadores.getRut());
        valores.put("ALTURA",jugadores.getAltura());
        valores.put("PESO", jugadores.getPeso());
        valores.put("EDAD", jugadores.getEdad());
        valores.put("NACIMIENTO",jugadores.getNacimiento());
        valores.put("SEXO",jugadores.getSexo());
        valores.put("CLUB", jugadores.getClub());
        valores.put("DISCAPACIDAD", jugadores.getDiscapacidad());
        db.insert("JUGADOR", null,valores);
    }

    //SELECT
    public List<Jugador> listaJugadores() {
        SQLiteDatabase db = getReadableDatabase();
        List<Jugador> jugadores = new ArrayList<>();
        Cursor cursor = db.query("JUGADOR",
                new String[]{"NOMBRE", "RUT", "ALTURA", "PESO", "EDAD", "NACIMIENTO", "SEXO", "CLUB", "DISCAPACIDAD"},
                null, null, null, null, null);
        cursor.moveToFirst();
        do{
            jugadores.add(new Jugador(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)));
        }while (cursor.moveToNext());
        cursor.close();
        db.close();
        return jugadores;
    }


/*
    //UPDATE
    public String actualizarJugador(Jugador j){

        String sqlTxt = "UPDATE JUGADOR SET NOMBRE = ? WHERE RUT = ?";
        Object[] argumentos = new Object[] {rut, j.getNombre()};
        try{
            getWritableDatabase().execSQL(sqlTxt, argumentos);
            return "Se cambio el nombre";
        } catch (SQLException ex) {
            return "No se puede cambiar el nombre";
        }
    }
    //otra forma
       public boolean update(String s1, String s2,String s3, String s4, int i5, String s6, String s7, String s8, String s9) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOMBRE",s1);
        contentValues.put("RUT",s2);
        contentValues.put("ALTURA",s3);
        contentValues.put("PESO",s4);
        contentValues.put("EDAD",i5);
        contentValues.put("NACIMIENTO",s6);
        contentValues.put("SEXO",s7);
        contentValues.put("CLUB",s8);
        contentValues.put("DISCAPACIDAD",s9);
        db.update("JUGADOR",contentValues,"RUT=?",new String[] {String.valueOf(s2)});
        return true;
    }*/

//SELECT
    public Jugador getJugador(String nombre){
        Jugador j;
        SQLiteDatabase db = getReadableDatabase();
        String sqlTxt = "SELECT NOMBRE, RUT, ALTURA, PESO, EDAD, NACIMIENTO, SEXO , CLUB , DISCAPACIDAD FROM JUGADOR WHERE NOMBRE=?";
        String[] argumentos = new String[] {nombre};
        try{
            Cursor cursor = db.rawQuery(sqlTxt,argumentos);
            cursor.moveToFirst();

            j = new Jugador(cursor.getString(0), cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getInt(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8) );

        }catch (SQLException ex) {
            j = null;
        }
        return j;
    }

    //DELETE
    public String eliminarJugador(){
        String sqlTxt = "DELETE FROM JUGADOR WHERE RUT = ?";
        try {
            getWritableDatabase().execSQL(sqlTxt);
            return "Se ha eliminado el jugador";
        }catch (SQLException ex) {
            return "No se ha podido eliminar";
        }
    }

}

