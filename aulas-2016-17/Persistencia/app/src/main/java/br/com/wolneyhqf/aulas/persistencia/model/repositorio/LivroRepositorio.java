package br.com.wolneyhqf.aulas.persistencia.model.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.aulas.persistencia.model.entidade.Livro;

/**
 * Created by wolney on 12/05/17.
 */

public class LivroRepositorio extends AppDatabase {

    public LivroRepositorio(Context context) {
        super(context);
    }

    public long salvar(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("titulo", livro.getTitulo());
            cv.put("autor", livro.getAutor());
            cv.put("editora", livro.getEditora());
            cv.put("ano", livro.getAno());
            long id = db.insert("livro", "", cv);
            livro.setId(id);
            return id;
        }finally {
            db.close();
        }
    }

    public long atualizar(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", livro.getId());
            cv.put("titulo", livro.getTitulo());
            cv.put("autor", livro.getAutor());
            cv.put("editora", livro.getEditora());
            cv.put("ano", livro.getAno());
            String[] args = new String[]{String.valueOf(livro.getId())};
            long count = db.update("livro", cv, "id=?", args);
            return count;
        }finally {
            db.close();
        }
    }

    public int deletar(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        try{
            int count = db.delete("livro", "id=?", new String[]{String.valueOf(livro.getId())});
            return count;
        }finally{
            db.close();
        }
    }

    public List<Livro> listar(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            Cursor cursor = db.query("livro", null, null, null, null, null, null, null);
            List<Livro> livros = toList(cursor);
            return livros;
        }finally {
            db.close();
        }
    }

    private List<Livro> toList(Cursor cursor){
        List<Livro> livros = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Livro livro = new Livro();
                livro.setId(cursor.getLong(cursor.getColumnIndex("id")));
                livro.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
                livro.setAutor(cursor.getString(cursor.getColumnIndex("autor")));
                livro.setEditora(cursor.getString(cursor.getColumnIndex("editora")));
                livro.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
                livros.add(livro);
            }while(cursor.moveToNext());
        }
        return livros;
    }

}

