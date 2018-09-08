package com.wolneyhqf.aula01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by wolney on 19/08/17.
 */

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_segunda);

        TextView textViewNome = (TextView) findViewById(R.id.texto_nome);

        Bundle bundleIntent = getIntent().getExtras();
        String nome = bundleIntent.getString("nome_digitado");

        textViewNome.setText(nome);

        Log.i("AppAula", "SegundaActivity.onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("AppAula", "SegundaActivity.onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("AppAula", "SegundaActivity.onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("AppAula", "SegundaActivity.onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("AppAula", "SegundaActivity.onStop()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("AppAula", "SegundaActivity.onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("AppAula", "SegundaActivity.onDestroy()");
    }

}
