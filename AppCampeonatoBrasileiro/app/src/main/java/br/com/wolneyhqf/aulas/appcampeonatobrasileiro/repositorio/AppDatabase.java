package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.repositorio;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase extends SQLiteOpenHelper {

    public final String TAG = "app_cbr";
    public static final String DB_NAME = "db_app_cbr";
    private static final int VERSAO_DB = 1;

    public AppDatabase(Context context){
        super(context, DB_NAME, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists clube(id integer primary key, nome text, estado text, estadio text, cidade text);");
        Log.d(TAG, "Tabelas criadas com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
