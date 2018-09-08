package com.wolneyhqf.aula01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoDeTextNome;
    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoDeTextNome = (EditText) findViewById(R.id.campo_de_texto_nome);
        botaoEnviar = (Button) findViewById(R.id.botao_enviar);

        Intent intent = new Intent(Intent.ACTION_CALL);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoDeTextNome.getText().toString();
                //Toast.makeText(getBaseContext(), "Seu nome é: " + nome, Toast.LENGTH_LONG).show();v
                Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                Bundle bundleIntent = new Bundle();
                bundleIntent.putString("nome_digitado", nome);
                intent.putExtras(bundleIntent);
                startActivity(intent);
            }
        });

        Log.i("AppAula", "MainActivity.onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("AppAula", "MainActivity.onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("AppAula", "MainActivity.onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("AppAula", "MainActivity.onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("AppAula", "MainActivity.onStop()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("AppAula", "MainActivity.onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("AppAula", "MainActivity.onDestroy()");
    }

}
