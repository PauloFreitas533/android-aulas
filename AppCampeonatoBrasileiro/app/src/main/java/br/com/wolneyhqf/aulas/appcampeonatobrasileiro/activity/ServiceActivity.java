package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.R;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.service.AppIntentService;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.service.AppService;

public class ServiceActivity extends AppCompatActivity {

    private int idThread = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(getBaseContext(), AppService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(getBaseContext(), AppService.class);
        stopService(intent);
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(getBaseContext(), AppIntentService.class);
        intent.putExtra("idThread", idThread);
        idThread++;
        startService(intent);
    }

    public void stopIntentService(View view) {
        Intent intent = new Intent(getBaseContext(), AppIntentService.class);
        stopService(intent);
    }
}
