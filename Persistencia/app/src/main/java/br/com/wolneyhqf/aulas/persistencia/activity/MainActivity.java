package br.com.wolneyhqf.aulas.persistencia.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.wolneyhqf.aulas.persistencia.R;
import br.com.wolneyhqf.aulas.persistencia.model.entidade.Livro;
import br.com.wolneyhqf.aulas.persistencia.model.repositorio.LivroRepositorio;
import br.com.wolneyhqf.aulas.persistencia.util.Prefs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences pref = getSharedPreferences("my_prefs", 0);
        int idade = pref.getInt("idade", 0);
        if(idade==0){
            Toast.makeText(this, "você não definiu uma idade", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "a idade salva é igual a " + String.valueOf(idade), Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarPref(View view) {
        SharedPreferences pref = getSharedPreferences("my_prefs", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("idade", 15);
        editor.commit();
    }

    public void salvarLivro(View view) {
        LivroRepositorio livroRepositorio = new LivroRepositorio(this);
        Livro livro = new Livro();
        livro.setAutor("Nelson Glauber");
        livro.setTitulo("Dominando o Android");
        livro.setEditora("Novatec");
        livro.setAno(2015);
        livroRepositorio.salvar(livro);
        Log.d("applivro", "Livro salvo!: " + livro.getId());
    }

    public void listarLivros(View view) {
        LivroRepositorio livroRepositorio = new LivroRepositorio(this);
        List<Livro> livros = livroRepositorio.listar();
        for(Livro livro : livros){
            Log.d("applivro", livro.getTitulo());
        }
    }
}
