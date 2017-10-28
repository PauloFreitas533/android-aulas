package br.com.wolneyhqf.aulas.persistencia.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.wolneyhqf.aulas.persistencia.R;
import br.com.wolneyhqf.aulas.persistencia.model.entidade.Livro;
import br.com.wolneyhqf.aulas.persistencia.model.repositorio.LivroRepositorio;

public class CadastroLivroActivity extends AppCompatActivity {

    private EditText editTextTitulo;
    private EditText editTextAutor;
    private EditText editTextEditora;
    private EditText editTextAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        editTextTitulo = (EditText) findViewById(R.id.edittext_titulo);
        editTextAutor = (EditText) findViewById(R.id.edittext_autor);
        editTextEditora = (EditText) findViewById(R.id.edittext_editora);
        editTextAno = (EditText) findViewById(R.id.edittext_ano);
    }

    public void salvarLivro(View view) {
        LivroRepositorio livroRepositorio = new LivroRepositorio(this);

        String titulo = editTextTitulo.getText().toString();
        String editora = editTextEditora.getText().toString();
        String autor = editTextAutor.getText().toString();
        String ano = editTextAno.getText().toString();

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setEditora(editora);
        livro.setAutor(autor);
        livro.setAno(Integer.parseInt(ano));

        livroRepositorio.salvar(livro);
        Toast.makeText(getBaseContext(), "Livro salvo com sucesso.", Toast.LENGTH_SHORT).show();
    }
}
