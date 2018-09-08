package br.com.wolneyhqf.aulas.persistencia.model.repositorio;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase extends SQLiteOpenHelper {

    public final String TAG = "persistencia";
    public static final String DB_NAME = "db_livros";
    private static final int VERSAO_DB = 1;

    public AppDatabase(Context context){
        super(context, DB_NAME, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists livro(id integer primary key autoincrement, titulo text, autor text, editora text, ano integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
