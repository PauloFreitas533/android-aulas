package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.model.Clube;

/**
 * Created by wolney on 21/03/17.
 */

public class ClubeDB extends AppDatabase {

    public ClubeDB(Context context) {
        super(context);
    }

    public long salvar(Clube clube){
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", clube.getId());
            contentValues.put("nome", clube.getNome());
            contentValues.put("estadio", clube.getEstadio());
            contentValues.put("estado", clube.getEstado());
            contentValues.put("cidade", clube.getCidade());
            long id = db.insert("clube", "", contentValues);
            return id;
        }finally {
            db.close();
        }
    }

    public long atualizar(Clube clube){
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", clube.getId());
            contentValues.put("nome", clube.getNome());
            contentValues.put("estadio", clube.getEstadio());
            contentValues.put("estado", clube.getEstado());
            contentValues.put("cidade", clube.getCidade());
            String _id = String.valueOf(clube.getId());
            String[] args = new String[]{_id};
            int count = db.update("clube", contentValues, "id=?", args);
            return count;
        }finally {
            db.close();
        }
    }

    public int deletar(Clube clube){
        SQLiteDatabase db = getWritableDatabase();
        try{
            int count = db.delete("clube", "id=?", new String[]{String.valueOf(clube.getId())});
            return count;
        }finally {
            db.close();
        }
    }

    public List<Clube> listarTodos(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            Cursor cursor = db.query("clube", null, null, null, null, null, null, null);
            return toList(cursor);
        }finally {
            db.close();
        }
    }

    private List<Clube> toList(Cursor cursor){
        List<Clube> clubes = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Clube clube = new Clube();
                clube.setId(cursor.getLong(cursor.getColumnIndex("id")));
                clube.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                clube.setEstadio(cursor.getString(cursor.getColumnIndex("estadio")));
                clube.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
                clube.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
                clubes.add(clube);
            }while(cursor.moveToNext());
        }
        return clubes;
    }
}
