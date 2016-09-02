package br.com.wolneyhqf.android.aulas.activityintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
 * Esta Activity contém exemplos sobre o ciclo de vida da Activity, Uso de Intent Explícita para navegar por outras telas da aplicação e passar parâmetros
 * Além do uso de Intents Implícitas e como utiliza-las para chamar outras activities e serviços do celular
 *
 */

public class MainActivity extends AppCompatActivity {

    // Constante para ser utilizada no LogCat (Gerador de logs do Android)
    public final String LOG_APP = "FAFICA-Aula03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gerando um log de INFO quando o método onCreate for invocado
        Log.i(LOG_APP, getLocalClassName() + ".onCreate()");


        // Utilizamos o método findViewById da Activity para recuperar as views no xml da Activity (activity_main.xml) para manipula-las no código Java
        Button botaoTela2 = (Button) findViewById(R.id.botao_tela2);

        // Tratando o evento de clique do botão - Aqui ele vai disparar a Intent Explícita para chamar a ActivityTela2
        botaoTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent Explícita - chama outra tela da aplicação passando como parâmetros a referẽncia da Activity Atual e a classe da Activity a ser aberta
                Intent intent = new Intent(MainActivity.this, Tela2Activity.class);

                // Passando um parâmetro para a próxima tela por meio da Intent
                // o método putExtra da Intent recebe dois parâmetros: o primeiro é a chave que identifica o parâmetro e o segundo é o valor do parâmetro
                // o metodo putExtra aceita todos os tipos de variáveis primitivas mais as interfaces serializable e parcelable, usadas para passar objetos como parâmetro
                intent.putExtra("nome_usuario", "João");

                // Método da Activity que dispara a Intent
                startActivity(intent);
            }
        });

        Button botaoAbrirNavegador = (Button) findViewById(R.id.botao_abrir_navegador);

        // Ao ser clicado, esse botão vai disparar uma Intent para o SO (Intent Implícita) solicitando que uma página de internet seja aberta
        botaoAbrirNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // A classe URI é utilizada para passar parâmetros padronizados de acordo com a arquitetura do Android - nesse exemplo é uma paǵina de internet
                Uri uri = Uri.parse("http://google.com");
                // Esta Intent (Implícita) recebe como parâmetro o código da ação que deverá ser executada (abrir o navegador) e o parâmetro enviado junto a ação (página de internet)
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        Button botaoIntentImplicita = (Button) findViewById(R.id.botaoI_intent_implicita);

        // Ao ser clicado, esse botão vai disparar uma Intent Implícita para o SO
        botaoIntentImplicita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Como parâmetro da Intent, passamos a ação que definimos para a Tela2Activity e Tela3Activity na declaração delas no AndroidManifest.xml
                // Desse modo, sempre que alguma aplicação do celular disparar uma Intent com esta ação ("fafica.pe.edu.br.acao01") nossa aplicação responderá dizendo que pode atender esta solicitação
                // Nesse exemplo, como duas activities diferentes foram configuradas para responder a esta ação, o SO vai perguntar para o usuário qual Activity ele deve abrir
                Intent intent = new Intent("br.com.wolneyhqf.android.aulas.minha_acao");
                startActivity(intent);
            }
        });
    }


    /*
     * Abaixo estão sobreescritos todos os métodos do ciclo de vida da Activity
     * Em cada método há um LogCat que irá mostrar o nome do método no log sempre que for invocado pelo SO
     *
     */

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(LOG_APP, getLocalClassName() + ".onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(LOG_APP, getLocalClassName() + ".onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(LOG_APP, getLocalClassName() + ".onPause()");
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.i(LOG_APP, getLocalClassName() + ".onStop()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(LOG_APP, getLocalClassName() + ".onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(LOG_APP, getLocalClassName() + ".onDestroy()");
    }
}
