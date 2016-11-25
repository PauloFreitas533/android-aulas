package br.com.wolneyhqf.android.aulas.webservices.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.wolneyhqf.android.aulas.webservices.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startClubesActivity(View view){
        Intent intent = new Intent(this, ClubesActivity.class);
        startActivity(intent);
    }


}
