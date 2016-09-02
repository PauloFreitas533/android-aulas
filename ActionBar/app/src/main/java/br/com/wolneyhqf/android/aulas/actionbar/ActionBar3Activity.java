package br.com.wolneyhqf.android.aulas.actionbar;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*
 * Esta Activity mostra duas Views Customizadas como botões de ação na ActionBar
 *
 */


public class ActionBar3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_action_bar3, menu);

        // SearchItem
        // Esta View é um botão de pesquisa que ao ser clicado exibe um campo de pesquisa na ActionBar
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Este método é o que captura os eventos do SearchItem
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            // Este método é invocado quando o usuário clica no botão pesquisar e submete o texto digitado
            @Override
            public boolean onQueryTextSubmit(String query){
                Toast.makeText(ActionBar3Activity.this, "Buscar texto: " + query, Toast.LENGTH_SHORT).show();
                return true;
            }

            // Este método é invocado a cada caracter digitado/apagado do campo de texto
            @Override
            public boolean onQueryTextChange(String newText){
                return false;
            }
        });

        // ShareActionProvider
        // Este é um botão de compartilhamento, que ao ser clicado dispara uma Intent pro SO para chamar aplicativos que podem compartilhar arquivos de texto
        MenuItem shareItem = menu.findItem(R.id.action_share);
        // Recuperando o ShareActionProvider (Botão de compartilhamento) por meio de uma classe (MenuItemCompat) da biblioteca de compatibilidade
        ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        // Criando a Intent que será disparada para o SO buscando aplicativos que possam compartilhar arquivos de texto
        Intent  shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/*");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Esse texto será compartilhado");
        // adicionando a Intent ao botão de compartilhamento, que ao ser clicado irá dispara-la
        share.setShareIntent(shareIntent);

        return true;
    }
}
