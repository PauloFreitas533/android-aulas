package br.com.wolneyhqf.android.aulas.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*
 * Esta Activity mostra como inflar um Menu de botões na ActionBar e como capturar seus eventos
 *
 */

public class ActionBar2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar2);
    }


    // Esse método da Activity infla o menu definido no XML ( menu_action_bar2.xml ) na ActionBar dessa Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_action_bar2, menu);
        return true;
    }

    // Esse método da Activity é chamado sempre que um botão da ActionBar é clicado
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Os Id's que estou verificando no Switch-case foram definidos por mim para cada item do menu_action_bar2.xml
        int id = item.getItemId();
        switch(id){
            case R.id.action_search:
                Toast.makeText(this, "Pesquisa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_refresh:
                Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
