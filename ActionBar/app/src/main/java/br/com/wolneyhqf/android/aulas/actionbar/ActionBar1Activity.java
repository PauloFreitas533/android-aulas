package br.com.wolneyhqf.android.aulas.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


/*
 * Esta Activity mostra como obter o objeto ActionBar e configurar o botão Up Navigation
 *
 */

public class ActionBar1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar1);

        // Método que retorna a ActionBar da Activity
        // OBS: estamos usando aqui a biblioteca de compatibilidade
        ActionBar actionBar = getSupportActionBar();

        // Método que ativida o botão Up Navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Aula 04 - Titulo modificado");

    }

    // Esse método da Activity é chamado sempre que um botão da ActionBar é clicado
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        // Estou verificando pelo Id do botão clicado se corresponde ao botão Up Navigation
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
